package by.bsuir.cafetopia.dto

import by.bsuir.cafetopia.model.User
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId

data class UserDto(
    @DocumentId var id: String = "",
    var name: String = "",
    var email: String = "",
    var country: String? = null,
    var city: String? = null,
    var gender: User.Gender? = null,
    var dateOfBirth: Timestamp? = null,
    val dateOfRegistration: Timestamp = Timestamp.now(),
    var bio: String? = null,
    var favoriteFood: String? = null
)
