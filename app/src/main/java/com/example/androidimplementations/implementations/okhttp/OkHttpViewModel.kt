package com.example.androidimplementations.implementations.okhttp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OkHttpViewModel: ViewModel() {

    private val repo = Repository()
    init{
        getDataWithRetrofit()
    }

    fun getData(){
        repo.getDataWithOkhttp()
    }

    fun getDataWithRetrofit(){
        CoroutineScope(Dispatchers.IO).launch {
            repo.getDataWithRetrofit()
        }
    }

}