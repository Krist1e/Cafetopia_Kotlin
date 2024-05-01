package by.bsuir.cafetopia.ui.screens.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.bsuir.cafetopia.ui.components.CafeListScreen
import by.bsuir.cafetopia.ui.components.ResponseView

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val favoritesResponse by viewModel.favorites.collectAsStateWithLifecycle()
    val selectedCafe by viewModel.selectedCafe.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    ResponseView(
        response = favoritesResponse,
        modifier = modifier.fillMaxSize()
    ) {
        CafeListScreen(
            cafes = it,
            selectedCafe = selectedCafe,
            onSelectCafe = viewModel::selectCafe,
            onFavoriteChange = viewModel::toggleFavorite,
            modifier = modifier,
            listState = listState
        )
    }
}