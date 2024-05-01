package by.bsuir.cafetopia.service

import by.bsuir.cafetopia.model.Response
import kotlinx.coroutines.flow.Flow

interface AuthenticationService {
    fun observeUserId(): Flow<String?>
    fun getUserId(): String?
    suspend fun signIn(email: String, password: String): Response<String>
    suspend fun signUp(email: String, name: String, password: String): Response<String>
    fun signOut()
}