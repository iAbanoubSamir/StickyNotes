package com.sticky.notes.di

import android.app.Application
import androidx.room.Room
import com.sticky.notes.feature_note.data.local.NoteDatabase
import com.sticky.notes.feature_note.data.repository.NoteRepositoryImpl
import com.sticky.notes.feature_note.domain.repository.NoteRepository
import com.sticky.notes.feature_note.domain.use_case.AddNoteUseCase
import com.sticky.notes.feature_note.domain.use_case.DeleteNoteUseCase
import com.sticky.notes.feature_note.domain.use_case.GetNotesUseCase
import com.sticky.notes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(database.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository)
        )
    }

}