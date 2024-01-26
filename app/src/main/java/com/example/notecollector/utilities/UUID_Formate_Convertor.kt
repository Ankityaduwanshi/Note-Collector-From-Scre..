package com.example.notecollector.utilities

import androidx.room.TypeConverter
import java.util.UUID


class UUID_Formate_Convertor {

    @TypeConverter
    fun uuidToString(uuid: UUID):String{

        return uuid.toString()
    }


    @TypeConverter
    fun stringToUUID(uuid: String):UUID{

        return UUID.fromString(uuid)
    }


}