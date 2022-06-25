package com.example.praktekroom.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="tb_student")
@Parcelize
data class StudentEntity(
    @PrimaryKey(autoGenerate=true)
    val id:Int = 0,
    val name:String,
    val kelas:String
) : Parcelable