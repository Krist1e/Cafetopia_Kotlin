package by.bsuir.cafetopia.service.implementations

import by.bsuir.cafetopia.dto.CafeDto
import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.model.Response
import by.bsuir.cafetopia.repository.CafeRepository
import by.bsuir.cafetopia.repository.FavoritesRepository
import by.bsuir.cafetopia.service.CafeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class CafeServiceImpl @Inject constructor(
    private val cafeRepository: CafeRepository,
    private val favoritesRepository: FavoritesRepository
) : CafeService {
    override fun getCafes(userId: String): Flow<Response<List<Cafe>>> = combine(
        cafeRepository.getCafes(),
        favoritesRepository.getFavorites(userId)
    ) { cafes, favorites ->
        Response.Success(
            cafes.map { cafe ->
                toModel(
                    cafe,
                    favorites.contains(cafe.id)
                )
            }
        )
    }

    override suspend fun toggleFavorite(cafe: Cafe, userId: String): Boolean {
        return if (cafe.isFavorite) {
            favoritesRepository.removeFavorite(userId, cafe.id)
            false
        } else {
            favoritesRepository.addFavorite(userId, cafe.id)
            true
        }
    }

    private fun toModel(
        cafe: CafeDto,
        isFavorite: Boolean
    ) = Cafe(
        id = cafe.id,
        name = cafe.name,
        address = cafe.address,
        tags = cafe.tags,
        options = cafe.options,
        phone = cafe.phone,
        email = cafe.email,
        website = cafe.website,
        openHours = cafe.openHours,
        closeHours = cafe.closeHours,
        image = cafe.image,
        images = cafe.images,
        description = cafe.description,
        isFavorite = isFavorite
    )
}