package com.udea.alerta.di

import com.udea.alerta.repository.GuardianRepositorio
import com.udea.alerta.repository.GuardianRepositorioRoom
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun GuarianRepository(repo: GuardianRepositorioRoom): GuardianRepositorio
}