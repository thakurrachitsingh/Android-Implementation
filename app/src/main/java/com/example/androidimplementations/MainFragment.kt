package com.example.androidimplementations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidimplementations.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    lateinit var view: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        return view.root
    }
}