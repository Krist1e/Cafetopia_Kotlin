package by.bsuir.cafetopia.di

import by.bsuir.cafetopia.service.AuthenticationService
import by.bsuir.cafetopia.service.CafeService
import by.bsuir.cafetopia.service.UserService
import by.bsuir.cafetopia.service.implementations.AuthenticationServiceImpl
import by.bsuir.cafetopia.service.implementations.CafeServiceImpl
import by.bsuir.cafetopia.service.implementations.UserServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServicesModule {
    @Binds
    @Singleton
    internal abstract fun bindAuthenticationService(
        authenticationService: AuthenticationServiceImpl
    ): AuthenticationService

    @Binds
    @Singleton
    internal abstract fun bindCafeService(
        cafeService: CafeServiceImpl
    ): CafeService

    @Binds
    @Singleton
    internal abstract fun bindUserService(
        userService: UserServiceImpl
    ): UserService
}