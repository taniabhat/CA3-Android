package com.example.ca3

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun StudentScreen(
    viewModel: StudentViewModel,
    modifier: Modifier = Modifier
) {

    val students by viewModel.students
        .collectAsStateWithLifecycle(emptyList())

    StudentList(students = students, modifier = modifier)
}

@Composable
fun StudentList(
    students: List<StudentEntity>,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier) {
        items(students) { student ->

            Text(text = student.name)
        }
    }
}
