package com.dalia.cache.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.dalia.cache.DatabaseConstants
import com.dalia.domain.model.common.Media

@Entity(
        tableName = DatabaseConstants.ICONS_TABLE_NAME,
)
data class CachedIcon(
        @PrimaryKey(autoGenerate = true)
        val iconId: Long = 0,
        val writingId: Long,
        val icon: String
) {
    companion object {
        fun fromDomain(writingId: Long, icon: Media.Icon): CachedIcon {
            return CachedIcon(
                    writingId = writingId,
                    icon = icon.icon
            )
        }
    }

    fun toDomain(): Media.Icon = Media.Icon(icon)
}
