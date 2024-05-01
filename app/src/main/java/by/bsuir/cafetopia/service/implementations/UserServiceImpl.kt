package by.bsuir.cafetopia.service.implementations

import android.os.Build
import androidx.annotation.RequiresApi
import by.bsuir.cafetopia.dto.UserDto
import by.bsuir.cafetopia.model.Response
import by.bsuir.cafetopia.model.User
import by.bsuir.cafetopia.repository.FavoritesRepository
import by.bsuir.cafetopia.repository.UserRepository
import by.bsuir.cafetopia.service.UserService
import com.google.firebase.Timestamp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
class UserServiceImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val favoritesRepository: FavoritesRepository
) : UserService {
    override fun getUser(id: String): Flow<Response<User>> = combine(
        userRepository.getUser(id),
        favoritesRepository.getFavorites(id)
    ) { user, favoriteCafes ->
        user?.let {
            Response.Success(
                toModel(
                    user,
                    favoriteCafes.size
                )
            )
        } ?: Response.Error("User not found")
    }

    override suspend fun createUser(userId: String, name: String, email: String) {
        userRepository.addUser(
            UserDto(
                id = userId,
                name = name,
                email = email
            )
        )
    }

    override suspend fun updateUser(user: User) {
        userRepository.updateUser(
            toDto(user)
        )
    }

    private fun toModel(
        user: UserDto,
        favoriteCafesCount: Int
    ) = User(
        id = user.id,
        name = user.name,
        email = user.email,
        country = user.country,
        city = user.city,
        gender = user.gender,
        dateOfBirth = user.dateOfBirth?.toDate()?.toInstant()?.atZone(ZoneId.systemDefault())
            ?.toLocalDate(),
        dateOfRegistration = user.dateOfRegistration.toDate().toInstant()
            ?.atZone(ZoneId.systemDefault())
            ?.toLocalDate() ?: LocalDateTime.now().toLocalDate(),
        bio = user.bio,
        favoriteFood = user.favoriteFood,
        favoriteCafesCount = favoriteCafesCount,
    )

    private fun toDto(
        user: User
    ) = UserDto(
        id = user.id,
        name = user.name,
        email = user.email,
        country = user.country,
        city = user.city,
        gender = user.gender,
        dateOfBirth = Timestamp(
            Date.from(
                user.dateOfBirth?.atStartOfDay(ZoneId.systemDefault())?.toInstant()
            )
        ),
        dateOfRegistration = Timestamp(
            Date.from(
                user.dateOfRegistration.atStartOfDay(ZoneId.systemDefault()).toInstant()
            )
        ),
        bio = user.bio,
        favoriteFood = user.favoriteFood
    )
}