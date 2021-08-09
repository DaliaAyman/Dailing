package com.dalia.domain.model.common

import org.threeten.bp.LocalDateTime

data class Writing(
    val id: Long,
    val text: String,
    val image: Media.Photo,
    val publishedAt: LocalDateTime
)
