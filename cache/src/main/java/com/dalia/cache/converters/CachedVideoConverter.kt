package com.dalia.cache.converters

import androidx.room.TypeConverter
import com.dalia.cache.model.CachedVideo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class CachedVideoConverter {

    @TypeConverter
    fun fromCachedVideo(cachedVideo: CachedVideo): String {
        val adapter: JsonAdapter<CachedVideo> = Moshi.Builder().build().adapter(CachedVideo::class.java)

        return adapter.toJson(cachedVideo)

//        return Moshi.Builder().build()
//            .adapter(CachedVideo::class.java)
//            .toJson(cachedVideoList)
    }

    @TypeConverter
    fun toCachedVideo(cachedVideoString: String): CachedVideo? {
        val adapter: JsonAdapter<CachedVideo> = Moshi.Builder().build().adapter(CachedVideo::class.java)

        return adapter.fromJson(cachedVideoString)
    }
}