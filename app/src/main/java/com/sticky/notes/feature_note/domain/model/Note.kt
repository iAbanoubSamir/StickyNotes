package com.sticky.notes.feature_note.domain.model

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val dateCreated: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(Color.Black, Color.Blue, Color.Red, Color.DarkGray, Color.Magenta)
    }
}