package by.bsuir.cafetopia.repository

import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavorites(userId: String): Flow<List<String>>
    suspend fun addFavorite(userId: String, cafeId: String)
    suspend fun removeFavorite(userId: String, cafeId: String)
}