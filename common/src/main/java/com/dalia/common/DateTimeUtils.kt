package com.dalia.common

import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.lang.Exception

object DateTimeUtils {
    fun parse(dateTimeString: String): LocalDateTime = try {
        LocalDateTime.parse(dateTimeString)
    } catch (e: Exception) {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
        LocalDateTime.parse(dateTimeString, dateFormatter)
    }

    fun now(): Instant {
        return Instant.now()
    }

    fun plusTime(time1: Instant, time2: Long) : Long {
        return time1.plusSeconds(time2).epochSecond
    }

    fun ofEpochSecond(time: Long): Instant{
        return Instant.ofEpochSecond(time)
    }

    fun ifTimeIsAfterNow(time: Instant): Boolean{
        return time.isAfter(Instant.now())
    }
}