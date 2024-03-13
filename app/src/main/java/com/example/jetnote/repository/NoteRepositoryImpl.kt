package com.example.jetnote.repository

import com.example.jetnote.data.NotesDao
import com.example.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val notesDao: NotesDao): NoteRepository {

    override suspend fun add(note: Note) = notesDao.insert(note)
    override suspend fun edit(note: Note) = notesDao.update(note)
    override suspend fun delete(note: Note) = notesDao.delete(note)
    override fun getAll() = notesDao.getAll().flowOn(Dispatchers.IO).conflate()
}