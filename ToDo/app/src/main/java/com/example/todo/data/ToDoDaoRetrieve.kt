package com.example.todo.data

import com.example.todo.data.roomDatabase.ToDoDao
import kotlinx.coroutines.Dispatchers

class ToDoDaoRetrieve (private val todoDao: ToDoDao){
    val takeAll = todoDao.selectAll()

    suspend fun insertTodo(todo: ToDo) {
        Dispatchers.IO.apply {
            todoDao.insert(todo)
        }
    }
    suspend fun deleteTodo(todo: ToDo){
        Dispatchers.IO.apply {
            todoDao.delete(todo.id)
        }
    }
    suspend fun updateTodo(isCompleted: Boolean, id: Long){
        Dispatchers.IO.apply {
            todoDao.updateTodo(isCompleted, id)
        }
    }
}