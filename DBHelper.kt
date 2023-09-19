package com.example.app01_memo

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class DBHelper : SQLiteOpenHelper {
    constructor(context: Context):super(context,"Memo.db",null,1)


    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("test","나옴")
        val sql ="""
            create table MemoTable(
            memo_idx integer primary key autoincrement,
            memo_subject text not null,
            memo_text text not null,
            memo_date date not null
            )
        """.trimIndent()

        db?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}