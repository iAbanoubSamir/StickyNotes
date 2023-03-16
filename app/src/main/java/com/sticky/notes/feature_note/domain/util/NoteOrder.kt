package com.sticky.notes.feature_note.domain.util

import android.provider.ContactsContract.CommonDataKinds.Note

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)
}