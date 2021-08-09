package com.dalia.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dalia.cache.DatabaseConstants
import com.dalia.domain.model.common.Media


@Entity(
    tableName = DatabaseConstants.PHOTOS_TABLE_NAME,
)
data class CachedPhoto(
    @PrimaryKey(autoGenerate = true)
    val photoId: Long = 0,
    val writingId: Long,
    val medium: String,
    val full: String
) {
    companion object {
        fun fromDomain(writingId: Long, photo: Media.Photo): CachedPhoto {
            val (medium, full) = photo

            return CachedPhoto(
                writingId = writingId,
                medium = medium,
                full = full
            )
        }
    }

    fun toDomain(): Media.Photo = Media.Photo(medium, full)
}