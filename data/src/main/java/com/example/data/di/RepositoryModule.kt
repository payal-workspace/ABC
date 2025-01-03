package com.example.data.di

import com.example.data.dataSource.SportsDataSource
import com.example.data.repository.SportsRepositoryImpl
import com.example.domain.repository.SportsRepository
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
    fun provideSportsRepository(
        dataSource: SportsDataSource
    ): SportsRepository = SportsRepositoryImpl(dataSource)
}