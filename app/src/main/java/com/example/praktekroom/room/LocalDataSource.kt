package com.example.praktekroom.room

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDataSource(context:Context) {
    private val appDatabase = AppDatabase.getDatabase(context)
    private val studentDao = appDatabase.studentDao()

    fun getStudents(callback:(List<StudentEntity>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            callback(studentDao.getAllStudents())
        }
    }

    fun saveStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.insertStudent(data)
        }
    }

    fun updateStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.updateStudent(data)
        }
    }

    fun deleteStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.deleteStudent(data)
        }
    }

}