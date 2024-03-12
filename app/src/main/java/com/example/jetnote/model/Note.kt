package com.example.jetnote.model

import java.util.Calendar
import java.util.Date
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val text: String,
    val entryDate: Date = Calendar.getInstance().time
)
