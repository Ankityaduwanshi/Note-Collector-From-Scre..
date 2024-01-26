package com.example.notecollector.dataBase.roomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notecollector.dataBase.NoteData

@Database(entities = [NoteData::class], version = 1,exportSchema = false)
abstract class DataBase : RoomDatabase() {


        abstract fun noteDao():Dao

}