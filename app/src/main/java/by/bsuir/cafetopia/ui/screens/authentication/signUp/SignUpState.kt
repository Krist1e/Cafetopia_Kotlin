package by.bsuir.cafetopia.ui.screens.authentication.signUp

import by.bsuir.cafetopia.model.Response

data class SignUpState(
    var email: String = "",
    var name: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var isValid: Boolean = false,
    var signUpResponse: Response<String> = Response.Success("")
)