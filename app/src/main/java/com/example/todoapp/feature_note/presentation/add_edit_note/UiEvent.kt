package com.example.todoapp.feature_note.presentation.add_edit_note

sealed class UiEvent{
    data class showSnackBar(val message: String): UiEvent()
    object SavedNote: UiEvent()
}