package by.bsuir.cafetopia.ui.screens.main

import androidx.annotation.DrawableRes
import by.bsuir.cafetopia.R
import by.bsuir.cafetopia.ui.screens.favorites.navigation.FAVORITES_ROUTE
import by.bsuir.cafetopia.ui.screens.home.navigation.HOME_ROUTE
import by.bsuir.cafetopia.ui.screens.profile.navigation.PROFILE_ROUTE

enum class MainScreenTab(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int
) {
    Home(HOME_ROUTE, "Home", R.drawable.home, R.drawable.home_filled),
    Favorites(FAVORITES_ROUTE, "Favorites", R.drawable.favorite, R.drawable.favorite_filled),
    Profile(PROFILE_ROUTE, "Profile", R.drawable.person, R.drawable.person_filled);

    companion object {
        fun fromRoute(route: String): MainScreenTab {
            return entries.first { it.route == route }
        }
    }
}