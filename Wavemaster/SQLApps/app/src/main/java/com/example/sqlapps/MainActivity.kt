package com.example.sqlapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlapps.databinding.ActivityMainBinding
import com.example.sqlapps.db.MyDbManager

class MainActivity : AppCompatActivity() {


    val myDbManager = MyDbManager(this)

    lateinit var binding : ActivityMainBinding

    val adapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {

            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter

            addButton.setOnClickListener {
//
                val i = Intent(this@MainActivity, EditActivity::class.java)
                startActivity(i)
//                myDbManager.openDb()
//                myDbManager.insertToDb(editName.text.toString(), editSurName.text.toString())
//
//                val dataList = myDbManager.readDbData()
//
////                for (i in dataList) {
////                    tvText.append(i)
////                    tvText.append("\n")
                }

            }
        }
    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//        myDbManager.closeDb()
//        myDbManager.dropTable()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        myDbManager.openDb()
//        val dataList = myDbManager.readDbData()
//
//        for (i in dataList) {
//            binding.tvText.append(i)
//            binding.tvText.append("\n")
//        }

//    }
//}