package com.dalia.remote.datasource

import com.dalia.data.repository.WritingsRemoteDataSource
import com.dalia.remote.api.WritingsApi
import com.dalia.remote.model.mappers.ApiWritingMapper
import javax.inject.Inject

class WritingsRemoteDataSourceImpl @Inject constructor(
        private val writingsApi: WritingsApi,
        private val apiWritingMapper: ApiWritingMapper,
) : WritingsRemoteDataSource