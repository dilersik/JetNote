package com.example.jetnote.repository

import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun add(note: Note)
    suspend fun edit(note: Note)
    suspend fun delete(note: Note)
    fun getAll(): Flow<List<Note>>
}