package com.dalia.remote.di

import com.dalia.data.repository.WritingsRemoteDataSource
import com.dalia.remote.datasource.WritingsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindWritingsRemoteDataSource(writingsRemoteDataSourceImpl: WritingsRemoteDataSourceImpl): WritingsRemoteDataSource

}