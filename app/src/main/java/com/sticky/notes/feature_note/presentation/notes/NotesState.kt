package com.sticky.notes.feature_note.presentation.notes

import com.sticky.notes.feature_note.domain.model.Note
import com.sticky.notes.feature_note.domain.util.NoteOrder
import com.sticky.notes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESC),
    val isOrderSectionVisible: Boolean = false
)