package org.a_cyb.hitchhikersmap.ui.map

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.a_cyb.hitchhikersmap.api.ApiRepository
import org.a_cyb.hitchhikersmap.models.CelestialBody
import org.a_cyb.hitchhikersmap.ui.map.MapUiState.*
import org.a_cyb.hitchhikersmap.util.TAG
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {
    private val _state: MutableStateFlow<MapUiState> = MutableStateFlow(Loading("Pizzza🍕"))
    val mapState: StateFlow<MapUiState> = _state

    init {
        fetchBodies()
    }

    private fun fetchBodies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    apiRepository
                        .fetchSolarBodyPositionsWithHorizonsApi()
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

