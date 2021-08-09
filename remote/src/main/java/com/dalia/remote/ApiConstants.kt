package com.dalia.remote

object ApiConstants {
    const val BASE_ENDPOINT = ""
    const val AUTH_ENDPOINT = "oauth2/token/"
    const val WRITINGS_ENDPOINT = "writings"

    const val KEY = "INSERT_YOUR_KEY_HERE"
    const val SECRET = "INSERT_YOUR_SECRET_HERE"

}

object ApiParameters {
    const val TOKEN_TYPE = "Bearer "
    const val AUTH_HEADER = "Authorization"
    const val GRANT_TYPE_KEY = "grant_type"
    const val GRANT_TYPE_VALUE = "client_credentials"
    const val CLIENT_ID = "client_id"
    const val CLIENT_SECRET = "client_secret"

    const val PAGE = "page"
    const val LIMIT = "limit"
    const val LOCATION = "location"
    const val DISTANCE = "distance"
    const val NAME = "name"
    const val AGE = "age"
    const val TYPE = "type"
}