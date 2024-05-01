package by.bsuir.cafetopia.service

import by.bsuir.cafetopia.model.Response
import by.bsuir.cafetopia.model.User
import kotlinx.coroutines.flow.Flow

interface UserService {
    fun getUser(id: String): Flow<Response<User>>
    suspend fun createUser(userId: String, name: String, email: String)
    suspend fun updateUser(user: User)
}