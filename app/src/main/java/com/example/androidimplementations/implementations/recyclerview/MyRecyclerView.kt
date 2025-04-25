package com.example.androidimplementations.implementations.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidimplementations.R

class MyRecyclerViewAdapter(val list: List<String>, val listener : AdapterListener): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text1.text = list[position]
        holder.text2.text = list[position]
        holder.itemView.setOnClickListener{
            listener.onClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(item: View): RecyclerView.ViewHolder(item){
        val text1 = item.findViewById<TextView>(R.id.textView1)
        val text2 = item.findViewById<TextView>(R.id.textView2)
    }
}

interface AdapterListener{
    fun onClick(data : String)
}