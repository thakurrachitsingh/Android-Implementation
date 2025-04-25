package com.example.androidimplementations.implementations.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidimplementations.R
import com.example.androidimplementations.databinding.FragmentOneBinding

open class FragmentOne : androidx.fragment.app.Fragment() {

    lateinit var layout : FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.root
        val fm = requireActivity().supportFragmentManager
    }
}