package com.example.jetnote.ui.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.model.Note
import com.example.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAll().distinctUntilChanged().collect {
                _noteList.value = it
            }
        }
    }

    fun add(note: Note) = viewModelScope.launch {
        repository.add(note)
    }

    fun edit(note: Note) = viewModelScope.launch {
        repository.edit(note)
    }

    fun remove(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }

    fun getAll() = noteList
}