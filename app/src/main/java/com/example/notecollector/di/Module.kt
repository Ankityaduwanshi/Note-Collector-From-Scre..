package com.example.notecollector.di

import android.content.Context
import androidx.room.Room
import com.example.notecollector.dataBase.roomDataBase.Dao
import com.example.notecollector.dataBase.roomDataBase.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton

    fun provideDao(database:DataBase):Dao = database.noteDao()


    @Provides
    @Singleton

    fun provideDatabase(@ApplicationContext context: Context): DataBase = Room.databaseBuilder(
        context = context,
        klass = DataBase::class.java,
        name = "NoteCollectorDatabase"
    ).fallbackToDestructiveMigration().build()
}