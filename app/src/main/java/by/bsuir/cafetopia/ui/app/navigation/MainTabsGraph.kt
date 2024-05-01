package by.bsuir.cafetopia.ui.app.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import by.bsuir.cafetopia.ui.screens.favorites.navigation.favoritesScreen
import by.bsuir.cafetopia.ui.screens.home.navigation.HOME_ROUTE
import by.bsuir.cafetopia.ui.screens.home.navigation.homeScreen
import by.bsuir.cafetopia.ui.screens.profile.navigation.profileScreen

const val MAIN_TABS_GRAPH = "tabs"

fun NavGraphBuilder.mainTabsGraph(modifier: Modifier = Modifier) {
    navigation(
        startDestination = HOME_ROUTE,
        route = MAIN_TABS_GRAPH
    ) {
        homeScreen()
        favoritesScreen()
        profileScreen()
    }
}