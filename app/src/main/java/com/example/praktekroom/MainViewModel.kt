package com.example.praktekroom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praktekroom.room.LocalDataSource
import com.example.praktekroom.room.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val students = MutableLiveData<List<StudentEntity>>()

    fun getStudent(context: Context) {
        val localDataSource = LocalDataSource(context)
        localDataSource.getStudents { result ->
            students.postValue(result)
        }
    }
}