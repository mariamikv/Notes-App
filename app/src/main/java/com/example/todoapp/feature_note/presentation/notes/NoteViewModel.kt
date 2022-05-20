package com.example.todoapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.feature_note.domain.model.Note
import com.example.todoapp.feature_note.domain.use_case.NoteUseCases
import com.example.todoapp.feature_note.domain.utli.NoteOrder
import com.example.todoapp.feature_note.domain.utli.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var deletedNote: Note? = null

    private var getNoteJob: Job? = null

    init {
        getNote(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order -> {
                if(state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType){
                        // if u pressed same button again which was already checked
                            // we don't need to change anything
                        return
                }
                getNote(event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNoteUseCase(event.note)
                    // save deleted note reference
                    deletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNoteUseCases(deletedNote ?: return@launch)
                    deletedNote = null
                }
            }
            is NotesEvent.OrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNote(noteOrder: NoteOrder){
        getNoteJob?.cancel()
        getNoteJob = noteUseCases.getNotesUseCase(noteOrder)
            .onEach {  notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            } .launchIn(viewModelScope)
    }
}