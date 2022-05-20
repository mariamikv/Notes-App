package com.example.todoapp.feature_note.presentation.utlis

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")
    object SplashScreen: Screen("splash_screen")
}