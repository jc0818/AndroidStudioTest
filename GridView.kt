package com.example.awd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.awd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var data1 = arrayOf(
        "그리드1","그리드2","그리드3","그리드4","그리드5",
        "그리드6","그리드7","그리드8","그리드9","그리드10",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,data1)
        binding.Grid.adapter = adapter1

        binding.Grid.setOnItemClickListener { parent, view, i, l ->
            binding.textView.text = "${data1[i]}"
        }
    }
}