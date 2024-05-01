package by.bsuir.cafetopia.di

import by.bsuir.cafetopia.repository.CafeRepository
import by.bsuir.cafetopia.repository.FavoritesRepository
import by.bsuir.cafetopia.repository.UserRepository
import by.bsuir.cafetopia.repository.implementations.FirestoreCafeRepository
import by.bsuir.cafetopia.repository.implementations.FirestoreFavoritesRepository
import by.bsuir.cafetopia.repository.implementations.FirestoreUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    @Singleton
    internal abstract fun bindCafeRepository(
        collectionRepository: FirestoreCafeRepository
    ): CafeRepository

    @Binds
    @Singleton
    internal abstract fun bindFavoriteRepository(
        cafeRepository: FirestoreFavoritesRepository
    ): FavoritesRepository

    @Binds
    @Singleton
    internal abstract fun bindUserRepository(
        userRepository: FirestoreUserRepository
    ): UserRepository
}