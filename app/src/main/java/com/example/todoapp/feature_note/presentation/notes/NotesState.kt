package com.example.todoapp.feature_note.presentation.notes

import com.example.todoapp.feature_note.domain.model.Note
import com.example.todoapp.feature_note.domain.utli.NoteOrder
import com.example.todoapp.feature_note.domain.utli.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
