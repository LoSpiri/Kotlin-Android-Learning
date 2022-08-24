package com.example.todo.ui.theme.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.example.todo.data.ToDo

@Composable
fun homeScreen(onNavigate:(ToDo?) -> Unit) {
    val viewModel = viewModel(HomeViewVodel::class.java)
    val state by viewModel.state.collectAsState()

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {onNavigate(null)}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }) {
        LazyColumn() {

        }
    }
}