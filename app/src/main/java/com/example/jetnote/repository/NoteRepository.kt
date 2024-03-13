package com.example.jetnote.repository

import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun add(note: Note): Boolean
    suspend fun edit(note: Note): Boolean
    suspend fun delete(note: Note): Boolean
    fun getAll(): Flow<List<Note>>
}