@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.example.jetnote.ui.views

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R
import com.example.jetnote.components.NoteButton
import com.example.jetnote.components.NoteInputText
import com.example.jetnote.data.NoteDataSource
import com.example.jetnote.model.Note
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun NoteView(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
) {
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "")
        },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(text = title, label = "Title", onValueChange = {
                if (it.trim().all { char -> char.isLetterOrDigit() })
                    title = it
            })

            NoteInputText(text = text, label = "Note", onValueChange = {
                if (it.trim().isNotEmpty())
                    text = it
            })

            Spacer(modifier = Modifier.height(12.dp))
            NoteButton(text = "Save", onClick = {
                if (title.isNotEmpty() && text.isNotEmpty()) {
                    onAddNote(Note(title = title, text = text))
                    title = ""
                    text = ""
                    Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                }
            })
        }
        HorizontalDivider(modifier = Modifier.padding(10.dp))
        LazyColumn {
            items(notes) { note ->
                NoteRow(
                    note = note,
                    onClick = {},
                    onLongClick = {
                        onRemoveNote(note)
                    }
                )
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onClick: (Note) -> Unit,
    onLongClick: (Note) -> Unit,
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 30.dp, bottomStart = 20.dp))
            .fillMaxWidth(),
        color = Color.LightGray,
        shadowElevation = 6.dp
    ) {

        Column(
            modifier
                .combinedClickable(
                    onClick = {
                        onClick(note)
                    },
                    onLongClick = {
                        onLongClick(note)
                    }
                )
                .padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            val formatter = SimpleDateFormat("EEE, dd MMM yyyy", Locale.getDefault())

            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Text(text = note.text, style = MaterialTheme.typography.bodyMedium)
            Text(text = formatter.format(note.entryDate), style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    NoteView(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}