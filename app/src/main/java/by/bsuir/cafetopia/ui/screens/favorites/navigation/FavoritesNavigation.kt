package by.bsuir.cafetopia.ui.screens.favorites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.bsuir.cafetopia.ui.screens.favorites.FavoritesScreen

const val FAVORITES_ROUTE = "favorites"

fun NavController.navigateToFavorites() = navigate(FAVORITES_ROUTE)

fun NavGraphBuilder.favoritesScreen() {
    composable(route = FAVORITES_ROUTE) {
        FavoritesScreen()
    }
}