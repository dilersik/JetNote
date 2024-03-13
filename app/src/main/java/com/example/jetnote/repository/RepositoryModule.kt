package com.example.jetnote.repository

import com.example.jetnote.data.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNoteRepository(notesDao: NotesDao): NoteRepository = NoteRepositoryImpl(notesDao)

}