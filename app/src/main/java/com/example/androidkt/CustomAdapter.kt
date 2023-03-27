package com.example.androidkt

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkt.databinding.ItemViewBinding


// 3. CustomAdapter 생성한다.
class CustomAdapter(val dataList:MutableList<DataList>):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    // 6. 아이템뷰 객체화
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemViewBinding:ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(itemViewBinding)
    }

    // 5. 사이즈 설정
    override fun getItemCount() = dataList.size


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewBinding = holder.itemViewBinding
        itemViewBinding.tvName.text = dataList.get(position).tvName
        itemViewBinding.tvAge.text = dataList.get(position).tvAge
        itemViewBinding.tvEmail.text = dataList.get(position).tvEmail
        itemViewBinding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        itemViewBinding.root.setOnClickListener {
            Toast.makeText(itemViewBinding.root.context, "${itemViewBinding.tvName.text}",Toast.LENGTH_SHORT).show()
        }
    }

    // 4. 뷰홀더집기 위해서 내부클래스를 만든다.
    class CustomViewHolder(val itemViewBinding: ItemViewBinding):RecyclerView.ViewHolder(itemViewBinding.root)
}