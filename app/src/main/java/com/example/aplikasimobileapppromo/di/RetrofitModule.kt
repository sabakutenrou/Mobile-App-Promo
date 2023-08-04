package com.example.aplikasimobileapppromo.di

import com.example.aplikasimobileapppromo.Constants.Companion.BASE_URL
import com.example.aplikasimobileapppromo.data.remote.PromoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePromoApi(retrofit: Retrofit): PromoApi {
        return retrofit.create(PromoApi::class.java)
    }
}