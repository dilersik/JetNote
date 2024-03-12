package com.example.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM notes")
    fun getAll()

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: Long): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}
