package com.example.todo.data.roomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo.data.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun selectAll(): Flow<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo:ToDo)

    @Query("Delete From todo WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM todo")
    suspend fun deleteAllTodo()

    @Query("UPDATE todo SET isComplete =:isComplete WHERE id = :id")
    suspend fun updateTodo(isComplete: Boolean, id: Long)
}