package com.example.todo

import android.content.Context
import com.example.todo.data.ToDoDaoRetrieve
import com.example.todo.data.roomDatabase.ToDoDatabase

object Graph {
    lateinit var database: ToDoDatabase
        private set
    val todoRepo by lazy {  // initialized when needed
        ToDoDaoRetrieve(database.todoDao())
    }

    fun provide(context: Context) {
        database = ToDoDatabase.getDatabase(context)
    }

}