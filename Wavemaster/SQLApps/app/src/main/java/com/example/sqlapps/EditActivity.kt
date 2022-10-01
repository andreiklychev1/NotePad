package com.example.sqlapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlapps.databinding.ActivityEditBinding
import com.example.sqlapps.db.MyDbManager

class EditActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    lateinit var binding : ActivityEditBinding

    val adapter = NoteAdapter()
    val index : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with (binding) {

            floatingActionButton.setOnClickListener{
                myDbManager.openDb()
                myDbManager.insertToDb(editTextName.text.toString(), editNote.text.toString())

                val dataList = myDbManager.readDbData()

                val note = Note(dataList[0], dataList[1])
                Log.v("MyApp", "${dataList}")
                Log.v("MyApp", "${note}")
                adapter.addNote(note)

                val u = Intent(this@EditActivity, MainActivity::class.java)
                startActivity(u)
            }
        }
    }
}