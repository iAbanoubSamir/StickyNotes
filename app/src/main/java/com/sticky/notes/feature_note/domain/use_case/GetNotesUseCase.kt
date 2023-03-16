package com.sticky.notes.feature_note.domain.use_case

import com.sticky.notes.feature_note.domain.model.Note
import com.sticky.notes.feature_note.domain.repository.NoteRepository
import com.sticky.notes.feature_note.domain.util.NoteOrder
import com.sticky.notes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESC)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.ASC -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                        is NoteOrder.Date -> notes.sortedBy { it.dateCreated }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    }
                }
                is OrderType.DESC -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                        is NoteOrder.Date -> notes.sortedByDescending { it.dateCreated }
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                    }
                }
            }
        }
    }
}