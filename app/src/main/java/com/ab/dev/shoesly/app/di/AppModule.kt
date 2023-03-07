package com.ab.dev.shoesly.app.di

import androidx.room.Room
import com.ab.dev.shoesly.app.constants.API
import com.ab.dev.shoesly.app.constants.DB
import com.ab.dev.shoesly.app.utils.SharedPreferencesHelper
import com.ab.dev.shoesly.data.source.local.db.room.AppDatabase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(API.BASE_URL)
            .build()
    }

    singleOf(::SharedPreferencesHelper)

    single {
        androidContext().resources
    }


    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DB.DB_NAME,
        ).build()
    }
}