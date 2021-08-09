package com.dalia.common

import java.io.IOException

class NetworkUnavailableException(message: String = "No network available :(") : IOException(message)

class NetworkException(message: String): Exception(message)

class EmptyTokenException(message: String = "No token available :(") : Exception(message)
