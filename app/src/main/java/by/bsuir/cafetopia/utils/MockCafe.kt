package by.bsuir.cafetopia.utils

import by.bsuir.cafetopia.model.Cafe
fun mockCafe() = Cafe(
    id = "1",
    name = "Cafe",
    address = "Address",
    tags = listOf("Tag1", "Tag2"),
    options = listOf("Option1", "Option2"),
    phone = "Phone",
    email = "Email",
    website = "Website",
    openHours = "Open",
    closeHours = "Close",
    image = "Image",
    images = listOf("Image1", "Image2"),
    description = "Description",
    isFavorite = false
)