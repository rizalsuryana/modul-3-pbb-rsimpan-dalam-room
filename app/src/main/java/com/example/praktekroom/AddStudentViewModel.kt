package com.example.praktekroom

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.praktekroom.room.LocalDataSource
import com.example.praktekroom.room.StudentEntity

class AddStudentViewModel : ViewModel() {
    fun addStudent(context: Context, nama:String, kelas:String, onSuccess:(Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.saveStudent(StudentEntity(0, nama, kelas))
        onSuccess(true)
    }

    fun updateStudent(context: Context, id:Int, nama:String, kelas:String, onSuccess: (Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.updateStudent(StudentEntity(id, nama, kelas))
        onSuccess(true)
    }

    fun deleteStudent(context: Context, data:StudentEntity, onSuccess: (Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.deleteStudent(data)
        onSuccess(true)
    }

}