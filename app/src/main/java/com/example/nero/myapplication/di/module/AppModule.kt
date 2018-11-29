package com.example.nero.myapplication.di.module

import com.example.nero.meteo.api.TypicodeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
internal class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTypicodeService(retrofit: Retrofit): TypicodeService {
        return retrofit.create(TypicodeService::class.java)
    }
}