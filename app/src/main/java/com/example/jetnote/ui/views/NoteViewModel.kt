package com.example.jetnote.ui.views

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetnote.data.NoteDataSource
import com.example.jetnote.model.Note

class NoteViewModel: ViewModel() {

    private val noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun add(note: Note) {
        noteList.add(note)
    }

    fun remove(note: Note) {
        noteList.remove(note)
    }

    fun getAll() = noteList
}