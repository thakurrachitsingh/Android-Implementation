package com.example.androidimplementations.implementations.services

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TempViewModal @Inject constructor(): ViewModel() {

    val data = MutableStateFlow(0)

    fun updateData(data: Int){
        this.data.value = data
    }

}