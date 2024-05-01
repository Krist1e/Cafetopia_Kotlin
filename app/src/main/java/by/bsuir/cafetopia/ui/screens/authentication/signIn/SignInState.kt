package by.bsuir.cafetopia.ui.screens.authentication.signIn

import by.bsuir.cafetopia.model.Response

data class SignInState(
    var email: String = "",
    var password: String = "",
    var isValid: Boolean = false,
    var signInResponse: Response<String> = Response.Success("")
)