package com.example.sqlapps.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(val context : Context) {

    val myDbHelper = MyDbHelper(context)
    var db : SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title : String, content : String){

        val values = ContentValues().apply{
            put(MyDbClassNames.COLUMN_NAME_TITLE, title)
            put(MyDbClassNames.COLUMN_NAME_SUBTITLE, content)
        }
        db?.insert(MyDbClassNames.TABLE_NAME, null, values)
    }

    fun readDbData() : ArrayList<String>{

        val dataContainer = ArrayList<String>()

        val cursor = db?.query(MyDbClassNames.TABLE_NAME, null, null, null, null, null, null)

        with (cursor) {

            while (cursor?.moveToNext()!!) {

                val dataText = cursor.getString(cursor.getColumnIndexOrThrow(MyDbClassNames.COLUMN_NAME_TITLE)).toString()
                dataContainer.add(dataText)
            }

        }
        cursor?.close()
        return dataContainer
    }

    fun closeDb(){
        myDbHelper.close()
    }

    fun dropTable() = myDbHelper.onUpgrade(db, 1, 1)
}