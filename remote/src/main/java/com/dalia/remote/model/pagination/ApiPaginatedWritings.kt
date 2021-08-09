package com.dalia.remote.model.pagination

import com.dalia.remote.model.ApiWriting
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiPaginatedWritings (
    @field:Json(name = "writings") val writings: List<ApiWriting>?,
    @field:Json(name = "pagination") val pagination: ApiPagination?
)