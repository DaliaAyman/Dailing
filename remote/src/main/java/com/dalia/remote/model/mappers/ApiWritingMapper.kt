package com.dalia.remote.model.mappers

import com.dalia.common.DateTimeUtils
import com.dalia.domain.model.common.*
import com.dalia.remote.model.ApiWriting
import javax.inject.Inject

class ApiWritingMapper @Inject constructor(
    private val apiPhotoMapper: ApiPhotoMapper,
    private val apiVideoMapper: ApiVideoMapper,
    private val apiIconMapper: ApiIconMapper
): ApiMapper<ApiWriting, Writing> {

    override fun mapToDomain(apiEntity: ApiWriting): Writing {
        return Writing(
                id = apiEntity.id ?: throw MappingException("Writing ID cannot be null"),
                text = apiEntity.text.orEmpty(),
                image = mapMainImage(apiEntity),
                publishedAt = DateTimeUtils.parse(apiEntity.publishedAt.orEmpty()), // throws exception if empty
        )
    }

    private fun mapMainImage(apiWriting: ApiWriting): Media.Photo {
        return Media.Photo(
            medium = apiWriting.photo?.medium.orEmpty(),
            full = apiWriting.photo?.full.orEmpty()
        )
    }
}
