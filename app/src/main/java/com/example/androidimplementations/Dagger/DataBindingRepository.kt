package com.example.androidimplementations.Dagger

import android.util.Log
import android.widget.Toast
import javax.inject.Inject

class DataBindingRepository @Inject constructor() {

    suspend fun getData(){
        Log.d("DataBindingRepository", "getData: Data fetched")
    }
}