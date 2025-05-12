package com.example.androidimplementations.implementations.recyclerview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidimplementations.R
import com.example.androidimplementations.databinding.FragmentRecyclerViewBinding
import com.example.androidimplementations.implementations.okhttp.OkHttpViewModel
import com.example.androidimplementations.implementations.okhttp.RetrofitDao.RetrofitHelper

class RecyclerViewFragment : Fragment(), AdapterListener {
    private lateinit var view: FragmentRecyclerViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = DataBindingUtil.inflate(inflater, R.layout.fragment_recycler_view, container, false)
        view.recyclerView.adapter = MyRecyclerViewAdapter(listOf("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew"), this)
        view.recyclerView.layoutManager = LinearLayoutManager(context)
        val retrofitInstance = RetrofitHelper.getInstance()
        Log.d("okhttpRepositoryRetro", "retrofitInstance: ${retrofitInstance.hashCode()}")
        val okHttpViewModel = OkHttpViewModel()
        return view.root
    }

    override fun onClick(data: String) {
        Toast.makeText(context, data, Toast.LENGTH_LONG).show()
    }
}