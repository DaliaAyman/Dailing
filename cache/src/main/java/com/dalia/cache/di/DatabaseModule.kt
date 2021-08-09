package com.dalia.cache.di

import android.content.Context
import androidx.room.Room
import com.dalia.cache.WritingsDatabase
import com.dalia.cache.converters.CachedPhotoConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
            @ApplicationContext context: Context,
            moshi: Moshi
    ): WritingsDatabase {
        CachedPhotoConverter.initialize(moshi)

        return Room.databaseBuilder(
                context,
                WritingsDatabase::class.java,
                "dailings.db"
        )
                .build()
    }

}