package com.dalia.remote.model.mappers

interface ApiMapper<E, D> {

    fun mapToDomain(apiEntity: E): D
}