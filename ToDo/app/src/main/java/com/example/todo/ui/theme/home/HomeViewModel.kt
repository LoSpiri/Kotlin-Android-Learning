package com.example.todo.ui.theme.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.Graph
import com.example.todo.data.ToDo
import com.example.todo.data.ToDoDaoRetrieve
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel(private val todoDaoRetrieve: ToDoDaoRetrieve = Graph.todoRepo): ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state

    private val todoList = todoDaoRetrieve.takeAll // private
    private val selected = MutableStateFlow(_state.value.selected) // private

    init {
        viewModelScope.launch {
            combine(todoList,selected) { todoList: List<ToDo>, selected: Boolean ->
                HomeViewState(todoList, selected)
            }.collect {
                _state.value = it
            }
        }
    }

    fun updateTodo(selected: Boolean, id: Long) = viewModelScope.launch {
        todoDaoRetrieve.updateTodo(selected, id)
    }

    fun deleteTodo(todo: ToDo) = viewModelScope.launch {
        todoDaoRetrieve.deleteTodo(todo)
    }

}


data class HomeViewState(
    val todoList: List<ToDo> = emptyList(),
    val selected: Boolean = false
)