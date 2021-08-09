package com.dalia.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiWriting(
        @field:Json(name = "id") val id: Long?,
        @field:Json(name = "text") val text: String?,
        @field:Json(name = "photo") val photo: ApiPhotoSizes?,
        @field:Json(name = "published_at") val publishedAt: String?
)

@JsonClass(generateAdapter = true)
data class ApiPhotoSizes(
    @field:Json(name = "small") val small: String?,
    @field:Json(name = "medium") val medium: String?,
    @field:Json(name = "large") val large: String?,
    @field:Json(name = "full") val full: String?
)

@JsonClass(generateAdapter = true)
data class ApiVideoLink(
    @field:Json(name = "embed") val embed: String?
)

@JsonClass(generateAdapter = true)
data class ApiIcon(
    @field:Json(name = "icon") val icon: String?
)