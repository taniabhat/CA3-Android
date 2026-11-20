package com.example.ca3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.Flow

class StudentViewModel(
    private val dao: StudentDao
) : ViewModel() {

    val students: Flow<List<StudentEntity>> =
        dao.getAllStudents()
}

class StudentViewModelFactory(private val dao: StudentDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
