package com.dalia.cache


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dalia.cache.converters.*
import com.dalia.cache.model.CachedIcon
import com.dalia.cache.model.CachedPhoto
import com.dalia.cache.model.CachedVideo

@Database(
    entities = [
        CachedPhoto::class, CachedVideo::class, CachedIcon::class,
    ],
    version = 1
)
@TypeConverters(CachedPhotoConverter::class, CachedVideoConverter::class, CachedIconConverter::class
)
abstract class WritingsDatabase : RoomDatabase()