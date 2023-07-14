package com.example.kmtest.di

import android.content.Context
import com.example.kmtest.data.remote.ApiConfig
import com.example.kmtest.data.remote.ApiService
import com.example.kmtest.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {
    @Provides
    fun provideApiService(): ApiService = ApiConfig.getApiService()

    @Provides
    @Singleton
    fun provideRepository(
        @ApplicationContext context: Context,
        apiService: ApiService
    ) = Repository(apiService, context)
}