package by.bsuir.cafetopia.dto

import com.google.firebase.firestore.DocumentId

data class CafeDto(
    @DocumentId var id: String = "",
    var name: String = "",
    var address: String = "",
    var tags: List<String> = listOf(),
    var options: List<String> = listOf(),
    var phone: String = "",
    var email: String = "",
    var website: String = "",
    var openHours: String = "",
    var closeHours: String = "",
    var image: String = "",
    var images: List<String> = listOf(),
    var description: String = ""
)
