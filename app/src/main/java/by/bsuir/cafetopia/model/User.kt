package by.bsuir.cafetopia.model

import java.time.LocalDate

data class User(
    var id: String,
    var name: String,
    var email: String,
    var country: String?,
    var city: String?,
    var gender: Gender?,
    var dateOfBirth: LocalDate?,
    val dateOfRegistration: LocalDate,
    var bio: String?,
    var favoriteFood: String?,
    var favoriteCafesCount: Int,
) {
    enum class Gender {
        Female,
        Male,
        Other
    }
}
