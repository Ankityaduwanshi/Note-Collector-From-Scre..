package com.example.notecollector.repo

import com.example.notecollector.dataBase.NoteData
import com.example.notecollector.dataBase.roomDataBase.Dao
import javax.inject.Inject

class repo @Inject constructor(private val dao: Dao) {

   suspend fun insert(noteData: NoteData) = dao.insert(noteData)

    suspend fun delete (noteData: NoteData) = dao.delete(noteData)

     fun getAll() = dao.getAll()


}