package com.example.todoapp.feature_note.domain.use_case

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCases: AddNoteUseCase,
    val getNoteUseCase: GetNoteUseCase
)