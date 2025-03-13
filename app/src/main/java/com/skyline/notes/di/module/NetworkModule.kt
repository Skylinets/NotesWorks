package com.skyline.notes.di.module

import com.skyline.notes.BuildConfig
import com.skyline.notes.api.ApiService
import com.skyline.notes.data.NotesRepository
import com.skyline.notes.di.LocalFileInterceptor
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { BuildConfig.FLAVOR }
    single { LocalFileInterceptor(get()) }

    single {
        OkHttpClient.Builder().apply {
            if (get<String>() == "dummy") {
                addInterceptor(get<LocalFileInterceptor>())
            }
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }

    factoryOf(::NotesRepository)
}