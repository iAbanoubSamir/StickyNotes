package com.sticky.notes.feature_note.domain.use_case

sealed class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase
)