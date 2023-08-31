package com.example.sqldb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqldb.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val helper = DBHelper(this)
       //helper.writableDatabase.close()
        binding.button1.setOnClickListener{
            val helper = DBHelper(this)
            val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
            val now = sdf.format(Date())

            val sql = """
                insert into TestTable (textData, intData, floatData, dateData)
                values (?,?,?,?)
            """.trimIndent()

            val arg1 = arrayOf("문자열1","100", "11.11",now)
            val arg2 = arrayOf("문자열2","200","22.22", now)

            helper.writableDatabase.execSQL(sql, arg1)
            helper.writableDatabase.execSQL(sql, arg2)
            helper.writableDatabase.close()
            
            binding.textview.text = "저장 완료"
        }

        binding.button2.setOnClickListener{
            val helper = DBHelper(this)

            val sql = """
                select * from TestTable
            """.trimIndent()

            val c1 = helper.writableDatabase.rawQuery(sql, null)
            binding.textview.text = ""
            while(c1.moveToNext())
            {
                val idx1 = c1.getColumnIndex("idx")
                val idx2 = c1.getColumnIndex("textData")
                val idx3 = c1.getColumnIndex("intData")
                val idx4 = c1.getColumnIndex("floatData")
                val idx5 = c1.getColumnIndex("dateData")

                val idx = c1.getInt(idx1)
                val textData = c1.getString(idx2)
                val intData = c1.getInt(idx3)
                val floatData = c1.getDouble(idx4)
                val dateData = c1.getString(idx5)

                binding.textview.append("idx: $idx\n")
                binding.textview.append("textData: $textData\n")
                binding.textview.append("intData: $intData\n")
                binding.textview.append("floatData: $floatData\n")
                binding.textview.append("dateData: $dateData\n")
            }
            helper.writableDatabase.close()
        }

        binding.button3.setOnClickListener{
            val helper = DBHelper(this)

            val sql="""
                update TestTable set textData = ? where idx = ?
            """.trimIndent()

            val arg1 = arrayOf("믄자열3", "1")

            helper.writableDatabase.execSQL(sql,arg1)
            helper.writableDatabase.close()

            binding.textview.text = "수정완료"
        }
    }
}
