package com.dalia.remote.model.mappers

import com.dalia.domain.model.common.Media
import com.dalia.remote.model.ApiIcon
import javax.inject.Inject

class ApiIconMapper @Inject constructor(): ApiMapper<ApiIcon?, Media.Icon> {

    override fun mapToDomain(apiEntity: ApiIcon?): Media.Icon {
        return Media.Icon(
            icon = apiEntity?.icon.orEmpty()
        )
    }
}