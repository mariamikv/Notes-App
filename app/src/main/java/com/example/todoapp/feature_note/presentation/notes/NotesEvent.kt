package com.example.todoapp.feature_note.presentation.notes

import com.example.todoapp.feature_note.domain.model.Note
import com.example.todoapp.feature_note.domain.utli.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object OrderSection: NotesEvent()
}
