package com.example.praktekroom.room

import androidx.room.*

@Dao
interface StudentDao {
    @Query("SELECT * FROM tb_student")
    suspend fun getAllStudents() : List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(data:StudentEntity)

    @Update
    suspend fun updateStudent(data:StudentEntity)

    @Delete
    suspend fun deleteStudent(data:StudentEntity)
}