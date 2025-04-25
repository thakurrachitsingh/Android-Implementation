package com.example.androidimplementations.Dagger

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DataBindingViewModel @Inject constructor(val repo: DataBindingRepository): ViewModel() {

    fun getData(){
        CoroutineScope(Dispatchers.IO).launch{
            repo.getData()
        }
    }
}