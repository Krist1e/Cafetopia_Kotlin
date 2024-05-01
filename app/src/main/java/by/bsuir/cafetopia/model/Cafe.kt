package by.bsuir.cafetopia.model

data class Cafe(
    var id: String,
    var name: String,
    var address: String,
    var tags: List<String>,
    var options: List<String>,
    var phone: String,
    var email: String,
    var website: String,
    var openHours: String,
    var closeHours: String,
    var image: String,
    var images: List<String>,
    var description: String,
    var isFavorite: Boolean
)
