package com.dalia.remote.model

import com.dalia.common.DateTimeUtils
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ApiToken(
    @field:Json(name = "token_type") val tokenType: String?,
    @field:Json(name = "expires_in") val expiresInSeconds: Int?,
    @field:Json(name = "access_token") val accessToken: String?
) {
    companion object {
        val INVALID = ApiToken("", -1, "")
    }

    @Transient
    private val requestedAt = DateTimeUtils.now()

    val expiresAt: Long
        get() {
            if (expiresInSeconds == null) return 0L

            return DateTimeUtils.plusTime(requestedAt, expiresInSeconds.toLong())
        }

    fun isValid(): Boolean {
        return tokenType != null && tokenType.isNotEmpty() &&
                expiresInSeconds != null && expiresInSeconds >= 0 &&
                accessToken != null && accessToken.isNotEmpty()
    }

}