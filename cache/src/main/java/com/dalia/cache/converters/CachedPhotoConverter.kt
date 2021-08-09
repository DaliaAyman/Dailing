package com.dalia.cache.converters

import androidx.room.TypeConverter
import com.dalia.cache.model.CachedPhoto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

object CachedPhotoConverter {

    lateinit var moshi: Moshi

    fun initialize(moshi: Moshi){
        this.moshi = moshi
    }

    @TypeConverter
    fun fromCachedPhoto(cachedPhoto: CachedPhoto): String {

        val adapter: JsonAdapter<CachedPhoto> = moshi.adapter(CachedPhoto::class.java)

        return adapter.toJson(cachedPhoto)

//        return Moshi.Builder().build()
//            .adapter(CachedPhoto::class.java)
//            .toJson(cachedPhotoList)
    }

    @TypeConverter
    fun toCachedPhoto(cachedPhotoString: String): CachedPhoto? {
        val adapter: JsonAdapter<CachedPhoto> = moshi.adapter(CachedPhoto::class.java)

        return adapter.fromJson(cachedPhotoString)
    }
}