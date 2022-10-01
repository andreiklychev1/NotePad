package com.example.sqlapps.db

import android.provider.BaseColumns

object MyDbClassNames : BaseColumns {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_SUBTITLE = "subtitle"
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyDb.db"

    const val CREATE_TABLE = "create table if exists $TABLE_NAME" +
            "(${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_TITLE text," +
            "$COLUMN_NAME_SUBTITLE text)"

    const val DROP_TABLE = "drop table IF exists $TABLE_NAME"
}