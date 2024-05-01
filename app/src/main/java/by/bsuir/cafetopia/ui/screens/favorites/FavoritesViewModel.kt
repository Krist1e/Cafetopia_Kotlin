package by.bsuir.cafetopia.ui.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.model.Response
import by.bsuir.cafetopia.service.AuthenticationService
import by.bsuir.cafetopia.service.CafeService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val cafeService: CafeService,
    private val authenticationService: AuthenticationService
): ViewModel() {
    private var _cafe = authenticationService.getUserId()?.let { userId ->
        cafeService.getCafes(userId)
    } ?: flowOf(Response.Error("User not found"))

    var favorites: StateFlow<Response<List<Cafe>>> = _cafe.map { response ->
        if (response is Response.Success) {
            Response.Success(response.data.filter { it.isFavorite })
        } else {
            response
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = Response.Loading
    )

    private var _selectedCafe: MutableStateFlow<Cafe?> = MutableStateFlow(null)
    var selectedCafe: StateFlow<Cafe?> = _selectedCafe

    fun selectCafe(cafe: Cafe) {
        _selectedCafe.value = cafe
    }

    fun toggleFavorite(cafe: Cafe) {
        val userId = authenticationService.getUserId() ?: return
        viewModelScope.launch {
            val newStatus = cafeService.toggleFavorite(cafe, userId)
            _selectedCafe.value = cafe.copy(isFavorite = newStatus)
        }
    }
}