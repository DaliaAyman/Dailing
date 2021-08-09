package com.dalia.remote.model.mappers

import com.dalia.domain.model.common.Media
import com.dalia.remote.model.ApiVideoLink
import javax.inject.Inject

class ApiVideoMapper @Inject constructor(): ApiMapper<ApiVideoLink?, Media.Video> {

  override fun mapToDomain(apiEntity: ApiVideoLink?): Media.Video {
    return Media.Video(video = apiEntity?.embed.orEmpty())
  }
}
