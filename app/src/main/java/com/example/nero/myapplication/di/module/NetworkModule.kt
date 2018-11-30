package com.example.nero.myapplication.di.module

import com.example.nero.myapplication.api.TypicodeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
internal class NetworkModule {
/*
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.connectTimeout(30, TimeUnit.SECONDS)
        client.readTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(30, TimeUnit.SECONDS)
        client.addInterceptor(interceptor)
        client.cache(cache)
        return client.build()
    }
*/
    @Singleton
    @Provides
    fun provideRetrofit(//gson: Gson, okHttpClient: OkHttpClient
     ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideTypicodeService(retrofit: Retrofit): TypicodeService {
        return retrofit.create(TypicodeService::class.java)
    }
}