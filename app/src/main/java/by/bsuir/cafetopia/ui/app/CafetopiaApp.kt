package by.bsuir.cafetopia.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import by.bsuir.cafetopia.ui.app.navigation.AUTHENTICATION_GRAPH
import by.bsuir.cafetopia.ui.app.navigation.authenticationGraph
import by.bsuir.cafetopia.ui.screens.main.navigation.MAIN_ROUTE
import by.bsuir.cafetopia.ui.screens.main.navigation.mainScreen

@Composable
fun CafetopiaApp(
    appViewModel: AppViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    val isAuthenticated by appViewModel.isAuthenticated.collectAsState()

    NavHost(
        navController,
        startDestination = if (isAuthenticated) MAIN_ROUTE else AUTHENTICATION_GRAPH
    ) {
        authenticationGraph(navController)
        mainScreen()
    }
}

@Composable
@Preview(name = "CafetopiaApp")
fun CafetopiaAppPreview() {
    CafetopiaApp()
}
