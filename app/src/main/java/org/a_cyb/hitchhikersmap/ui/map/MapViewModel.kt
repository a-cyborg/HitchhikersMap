package org.a_cyb.hitchhikersmap.ui.map

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.a_cyb.hitchhikersmap.api.ApiRepository
import org.a_cyb.hitchhikersmap.api.HorizonsApiBodyId
import org.a_cyb.hitchhikersmap.api.HorizonsApiResponse
import org.a_cyb.hitchhikersmap.models.CelestialBody
import org.a_cyb.hitchhikersmap.models.XYZVector
import org.a_cyb.hitchhikersmap.ui.map.MapUiState.*
import org.a_cyb.hitchhikersmap.util.TAG
import java.util.Collections.list
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {
    private val _state: MutableStateFlow<MapUiState> = MutableStateFlow(Loading("Pizzza🍕"))
    val mapState: StateFlow<MapUiState> = _state

    init {
        fetchAndParseSolarBodies()
    }

    private fun fetchAndParseSolarBodies() {
        var bodies: List<CelestialBody> = listOf()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Fetch
                apiRepository
                    // .fechAndParseEphemerisOfSolarBodies()
                    // DEV MODE
                    .fetchDummySolarBodyPositions()
                    .collect { if (it is Success) bodies = it.data else _state.emit(it) }

                // Scale the XYZVectors
                bodies.map {
                    it.positions.map { position ->
                        position.xyz = scaleVectorEphemeris(position.xyz)
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "fetchBodies: ${e.message}\n${e.stackTrace}", e)
                _state.emit(Error(Throwable(e.message, e.cause)))
            }

            _state.emit(Success(bodies))
        }
    }

    private fun scaleVectorEphemeris(xyz: XYZVector): XYZVector {
        val scaleFactor = 3.33E-6.toFloat()

        return XYZVector(
            x = xyz.x * scaleFactor,
            y = xyz.y * scaleFactor,
            z = xyz.z * scaleFactor
        )
    }

    private fun fetchAndParseSolarBodies1() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    apiRepository
//                        .fetchSolarBodyPositions()
                        // DEV MODE
                        .fetchDummySolarBodyPositions()
                        .collect { _state.emit(it) }
                } catch (e: Exception) {
                    Log.e(TAG, "fetchBodies: ${e.message}\n${e.stackTrace}", e)
                    _state.emit(Error(Throwable(e.message, e.cause)))
                }
            }
        }
    }

    fun debugDoubleTap() {
        Log.d(TAG, "debugDoubleTap: ")
    }
}

sealed interface MapUiState {
    data class Loading(val info: String) : MapUiState
    data class Error(val throwable: Throwable) : MapUiState
    data class Success(val data: List<CelestialBody>) : MapUiState
}

