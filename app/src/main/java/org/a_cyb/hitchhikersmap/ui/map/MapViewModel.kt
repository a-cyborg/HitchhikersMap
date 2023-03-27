@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.ui.map

import android.util.Log
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import org.a_cyb.hitchhikersmap.api.ApiRepository
import org.a_cyb.hitchhikersmap.models.Planet
import org.a_cyb.hitchhikersmap.ui.map.MapUiState.*
import org.a_cyb.hitchhikersmap.util.TAG
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(apiRepository: ApiRepository) : ViewModel() {

    var mapState: StateFlow<MapUiState> = apiRepository.devModeOfflineGetPlanetEphemeris()
        .map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun debugDoubleTap() {
        Log.d(TAG, "debugDoubleTap: ")
    }
}

sealed interface MapUiState {
    object Loading : MapUiState
    data class Error(val throwable: Throwable) : MapUiState
    data class Success(val data: List<Planet>) : MapUiState
}