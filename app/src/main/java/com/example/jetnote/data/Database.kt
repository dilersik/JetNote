package com.example.jetnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnote.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}