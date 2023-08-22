package com.example.shxt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shxt.databinding.ActivityMainBinding
import com.example.shxt.databinding.RowBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var imgRes = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3,
        R.drawable.imgflag4, R.drawable.imgflag5,
        R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )

    var data1 = arrayOf(
        "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter1 = RecyclerAdapter()

        binding.recycler1.adapter = adapter1
        binding.recycler1.layoutManager = LinearLayoutManager(this)
    }

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val itemView = layoutInflater.inflate(R.layout.row,null)
            val holder = ViewHolderClass(RowBinding.bind(itemView))

            return holder

        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView.text = data1[position]
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        inner class ViewHolderClass(binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {
            val rowImageView = binding.rowimageView
            val rowTextView = binding.rowTextView
        }
    }
}
