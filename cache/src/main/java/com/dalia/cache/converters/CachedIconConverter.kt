package com.dalia.cache.converters

import androidx.room.TypeConverter
import com.dalia.cache.model.CachedIcon
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class CachedIconConverter {

    @TypeConverter
    fun fromCachedIcon(cachedIcon: CachedIcon): String {
        val adapter: JsonAdapter<CachedIcon> = Moshi.Builder().build().adapter(CachedIcon::class.java)

        return adapter.toJson(cachedIcon)

//        return Moshi.Builder().build()
//            .adapter(CachedIcon::class.java)
//            .toJson(cachedIconList)
    }

    @TypeConverter
    fun toCachedIcon(cachedIconString: String): CachedIcon? {
        val adapter: JsonAdapter<CachedIcon> = Moshi.Builder().build().adapter(CachedIcon::class.java)

        return adapter.fromJson(cachedIconString)
    }
}