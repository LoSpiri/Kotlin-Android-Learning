package com.example.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo (
    val todo: String,
    val time: String,
    val isComplete: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Long
    )