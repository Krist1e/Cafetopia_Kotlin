package by.bsuir.cafetopia.repository

import by.bsuir.cafetopia.dto.UserDto
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id: String): Flow<UserDto?>
    suspend fun addUser(user: UserDto)
    suspend fun updateUser(user: UserDto)
}