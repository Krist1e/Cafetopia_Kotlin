package by.bsuir.cafetopia.ui.screens.home

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
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val cafesResponse by viewModel.cafes.collectAsStateWithLifecycle()
    val selectedCafe by viewModel.selectedGame.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    ResponseView(
        response = cafesResponse,
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