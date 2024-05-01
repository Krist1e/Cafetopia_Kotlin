package by.bsuir.cafetopia.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.bsuir.cafetopia.ui.app.navigation.MAIN_TABS_GRAPH
import by.bsuir.cafetopia.ui.app.navigation.mainTabsGraph
import by.bsuir.cafetopia.ui.screens.main.components.TabsNavigationSuiteScaffold
import by.bsuir.cafetopia.ui.theme.CafetopiaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val topBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val screenTitle =
        MainScreenTab.fromRoute(currentDestination?.route ?: MainScreenTab.Home.route).title

    TabsNavigationSuiteScaffold(
        navController = navController,
        currentDestination = currentDestination
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(screenTitle) },
                    scrollBehavior = topBarScrollBehavior,
                )
            }, modifier = modifier
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = MAIN_TABS_GRAPH,
                modifier = modifier
                    .padding(top = paddingValues.calculateTopPadding())
                    .nestedScroll(topBarScrollBehavior.nestedScrollConnection)
            ) {
                mainTabsGraph()
            }
        }
    }
}

@Preview(name = "MainScreen")
@Composable
private fun PreviewMainScreen() {
    CafetopiaTheme {
        MainScreen()
    }
}