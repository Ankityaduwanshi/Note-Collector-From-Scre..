package com.example.notecollector.dataBase.roomDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notecollector.dataBase.NoteData
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("Select * from Note_Data_Table")
    fun getAll(): Flow<List<NoteData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteData: NoteData)

    @Delete
    suspend fun delete(noteData: NoteData)

}