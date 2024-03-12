package com.example.jetnote.di

import android.content.Context
import androidx.room.Room
import com.example.jetnote.data.Database
import com.example.jetnote.data.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(database: Database): NotesDao = database.notesDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, "jetnotes")
            .fallbackToDestructiveMigration()
            .build()
}