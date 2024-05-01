package by.bsuir.cafetopia.repository

import by.bsuir.cafetopia.dto.CafeDto
import kotlinx.coroutines.flow.Flow

interface CafeRepository {
    fun getCafes(): Flow<List<CafeDto>>
}