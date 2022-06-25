package com.example.praktekroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.praktekroom.databinding.ActivityAddStudentBinding
import com.example.praktekroom.room.StudentEntity

class AddStudentActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddStudentBinding
    private lateinit var viewModel:AddStudentViewModel

    private var isEdit = false
    private var data:StudentEntity? = null

    companion object {
        val STUDENT_EXTRA = "student"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = intent.getParcelableExtra(STUDENT_EXTRA)

        if (data != null) {
            isEdit = true
            binding.btnHapus.visibility = View.VISIBLE
            binding.editName.setText(data?.name)
            binding.editKelas.setText(data?.kelas)
        } else {
            isEdit = false
            binding.btnHapus.visibility = View.GONE
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        viewModel = ViewModelProvider(this)[AddStudentViewModel::class.java]

        binding.btnSimpan.setOnClickListener {
            saveStudent()
        }

        binding.btnHapus.setOnClickListener {
            viewModel.deleteStudent(this, data!!) {
                Toast.makeText(this, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun saveStudent() {
        if (binding.editName.text.toString() == "" || binding.editKelas.text.toString() == "") {
            Toast.makeText(this, "Isi Form yang ada", Toast.LENGTH_SHORT).show()
        } else {
            if (isEdit) {
                viewModel.updateStudent(this, data?.id!!, binding.editName.text.toString(), binding.editKelas.text.toString()) {
                    successSaveStudent()
                }
            } else {
                viewModel.addStudent(this, binding.editName.text.toString(), binding.editKelas.text.toString()) {
                    successSaveStudent()
                }
            }
        }
    }

    private fun successSaveStudent() {
        Toast.makeText(this, "Berhasil Menyimpan Data", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}