package com.example.jetnote.data

import com.example.jetnote.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> = listOf(
        Note(title = "A good day", text = "We went on a vacation by the lake"),
        Note(title = "Android Compose", text = "Working on Android Compose course today"),
        Note(title = "Keep at it...", text = "Sometimes things just happen"),
        Note(title = "A movie day", text = "Watching a movie with family today"),
        Note(title = "A movie day", text = "Watching a movie with family today"),
        Note(title = "A movie day", text = "Watching a movie with family today"),
        Note(title = "A movie day", text = "Watching a movie with family today"),
        Note(title = "A movie day", text = "Watching a movie with family today"),
        Note(title = "A movie day", text = "Watching a movie with family today"),
        Note(title = "A movie day", text = "Watching a movie with family")
    )
}