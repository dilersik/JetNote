package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.ui.theme.JetNoteTheme
import com.example.jetnote.ui.views.NoteView
import com.example.jetnote.ui.views.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    JetNoteApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun JetNoteApp(noteViewModel: NoteViewModel) {
    NoteView(
        notes = noteViewModel.noteList.collectAsState().value,
        onAddNote = { noteViewModel.add(it) },
        onRemoveNote = { noteViewModel.remove(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteTheme {
        NoteView(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
    }
}