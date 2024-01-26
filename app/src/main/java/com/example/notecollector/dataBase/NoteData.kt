package com.example.notecollector.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.notecollector.utilities.DateTime_Formate_Converter
import com.example.notecollector.utilities.UUID_Formate_Convertor
import java.time.LocalDateTime
import java.util.UUID


@TypeConverters(DateTime_Formate_Converter::class,UUID_Formate_Convertor::class)
@Entity(tableName = "Note_Data_Table")
data class NoteData(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "dateTime")
    val dateTime: LocalDateTime = LocalDateTime.now()
)
