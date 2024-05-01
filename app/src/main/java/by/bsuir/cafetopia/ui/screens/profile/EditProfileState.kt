package by.bsuir.cafetopia.ui.screens.profile

import by.bsuir.cafetopia.model.User
import java.time.LocalDate

data class EditProfileState(
    val name: String = "",
    val country: String = "",
    val city: String = "",
    val gender: User.Gender? = null,
    val dateOfBirth: LocalDate? = null,
    val bio: String = "",
    val favoriteFood: String = ""
)