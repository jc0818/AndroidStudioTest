package com.example.sqldb

import  android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context,"test.db", null, 1)

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("test","데이터베이스가 생성되었습니다.")

        val sql ="""
            create table TestTable
            (
                idx integer primary key autoincrement,
                textData text not null,
                intData integer not null,
                floatData real not null,
                dateData date not null
                
            )
        """.trimIndent()
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}