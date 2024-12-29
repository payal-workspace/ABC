package com.example.data.di

import com.example.data.dataSource.SportsTable
import com.example.data.repository.SportsRepository
import com.example.data.repository.SportsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        dataSource: SportsTable
    ): SportsRepository = SportsRepositoryImpl(
        dataSource
    )
}