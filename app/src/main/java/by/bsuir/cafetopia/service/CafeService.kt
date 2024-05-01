package by.bsuir.cafetopia.service

import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.model.Response
import kotlinx.coroutines.flow.Flow

interface CafeService {
    fun getCafes(userId: String): Flow<Response<List<Cafe>>>
    suspend fun toggleFavorite(cafe: Cafe, userId: String): Boolean
}