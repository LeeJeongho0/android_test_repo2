package com.example.androidkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var dataList:MutableList<DataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 데이터 리스트를 만들어서 adapter 제공
        dataList = mutableListOf<DataList>()
        for(i in 1..30){
            if(i % 2 == 0){
                dataList.add(DataList(tvName = "홍길동${i}","${20+i}세","rlaeo${i}@nate.com",R.drawable.man))
            }else{dataList.add(DataList(tvName = "홍길녀${i}","${20+i}세","rlaeo${i}@nate.com",R.drawable.woman))
            }
        }

        // 2. CustomAdapter(dataList)
        val customAdapter = CustomAdapter(dataList)
        // 3. 리사이클러뷰에 어댑터를 적용시킴
        binding.recyclerView.adapter = customAdapter
        // 4. layoutManager 통해서 리사이클러뷰 방향을 설정
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager
    }
}