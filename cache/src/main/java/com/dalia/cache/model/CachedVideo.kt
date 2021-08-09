package com.dalia.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dalia.cache.DatabaseConstants
import com.dalia.domain.model.common.Media

@Entity(
    tableName = DatabaseConstants.VIDEOS_TABLE_NAME,
)
data class CachedVideo(
    @PrimaryKey(autoGenerate = true)
    val videoId: Long = 0,
    val writingId: Long,
    val video: String
) {
  companion object {
    fun fromDomain(writingId: Long, video: Media.Video): CachedVideo {
      return CachedVideo(
          writingId = writingId,
          video = video.video
      )
    }
  }

  fun toDomain(): Media.Video = Media.Video(video)
}
