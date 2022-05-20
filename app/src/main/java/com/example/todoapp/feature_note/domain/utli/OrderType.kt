package com.example.todoapp.feature_note.domain.utli

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
