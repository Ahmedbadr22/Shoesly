package com.ab.dev.shoesly.app.di

import com.ab.dev.shoesly.data.source.local.db.room.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single {
        val database = get<AppDatabase>()
        database.getBrandDao()
    }

    single {
        val database = get<AppDatabase>()
        database.getShoeDao()
    }

    single {
        val database = get<AppDatabase>()
        database.getReviewDao()
    }

    single {
        val database = get<AppDatabase>()
        database.getSizeDao()
    }

    single {
        val database = get<AppDatabase>()
        database.getStockItemDao()
    }

    single {
        val database = get<AppDatabase>()
        database.getColorDao()
    }
}