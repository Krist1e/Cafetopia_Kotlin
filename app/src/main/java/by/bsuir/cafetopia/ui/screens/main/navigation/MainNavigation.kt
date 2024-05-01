package by.bsuir.cafetopia.ui.screens.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.bsuir.cafetopia.ui.screens.main.MainScreen

const val MAIN_ROUTE = "main"

fun NavGraphBuilder.mainScreen() {
    composable(route = MAIN_ROUTE) {
        MainScreen()
    }
}