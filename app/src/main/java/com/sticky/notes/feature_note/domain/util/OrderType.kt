package com.sticky.notes.feature_note.domain.util

sealed class OrderType {
    object ASC : OrderType()
    object DESC : OrderType()
}