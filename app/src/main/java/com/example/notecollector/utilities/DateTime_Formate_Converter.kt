package com.example.notecollector.utilities

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class DateTime_Formate_Converter {

    @TypeConverter

    fun localDateTimeToLong(localDateTime: LocalDateTime):Long{

        return localDateTime.toEpochSecond(ZoneOffset.UTC)
    }

    @TypeConverter
    fun longToLocalDateTime(long: Long):LocalDateTime{
        val instant = Instant.ofEpochSecond(long)

        return LocalDateTime.ofInstant(instant,ZoneOffset.UTC)
    }
}