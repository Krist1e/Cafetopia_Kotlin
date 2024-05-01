package by.bsuir.cafetopia.ui.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import by.bsuir.cafetopia.ui.screens.authentication.navigation.authenticationScreen
import by.bsuir.cafetopia.ui.screens.authentication.navigation.navigateToSignIn
import by.bsuir.cafetopia.ui.screens.authentication.navigation.navigateToSignUp
import by.bsuir.cafetopia.ui.screens.welcome.navigation.WELCOME_ROUTE
import by.bsuir.cafetopia.ui.screens.welcome.navigation.welcomeScreen

const val AUTHENTICATION_GRAPH = "authentication"

fun NavGraphBuilder.authenticationGraph(navController: NavController) {
    navigation(
        startDestination = WELCOME_ROUTE,
        route = AUTHENTICATION_GRAPH
    ) {
        welcomeScreen(
            onSignInMove = { navController.navigateToSignIn() },
            onSignUpMove = { navController.navigateToSignUp() }
        )
        authenticationScreen(
            onBackClick = { navController.popBackStack() }
        )
    }
}