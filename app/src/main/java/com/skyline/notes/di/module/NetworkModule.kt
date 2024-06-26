package com.skyline.notes.di.module

import android.content.Context
import com.skyline.notes.BuildConfig
import com.skyline.notes.api.ApiService
import com.skyline.notes.di.LocalFileInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(context: Context): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.FLAVOR == "dummy") {
            clientBuilder.addInterceptor(LocalFileInterceptor(context))
        }
        return clientBuilder.build()
    }
    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}