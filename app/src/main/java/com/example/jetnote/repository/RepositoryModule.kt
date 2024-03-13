package com.example.jetnote.repository

import com.example.jetnote.data.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideNoteRepository(notesDao: NotesDao) = NoteRepositoryImpl(notesDao)

}