package com.example.androidimplementations.implementations.okhttp

import android.util.Log
import com.example.androidimplementations.implementations.okhttp.RetrofitDao.RetrofitDao
import com.example.androidimplementations.implementations.okhttp.dataModel.Response
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class Repository {
    lateinit var client: OkHttpClient

    fun getDataWithOkhttp(){
        CoroutineScope(Dispatchers.IO).launch {
            client = OkHttpClient()
            val request = Request.Builder().url("https://api.marketstack.com/v1/eod?access_key=b25239ec653add689085bdaa6bd0ff44&symbols=AAPL").build()
            client.newCall(request).enqueue(object : okhttp3.Callback {
                override fun onFailure(call: okhttp3.Call, e: IOException) {
                    // Handle failure
                    Log.d("okhttpRepository", "failure : ${e.message}")
                }

                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                    if (response.isSuccessful) {
                        val responseData = response.body?.string()
                        val data = Gson().fromJson(responseData, Response::class.java)
                        Log.d("okhttpRepository", data.pagination.toString())
                    }
                }
            })
        }
    }

    suspend fun getDataWithRetrofit(){
        val deferredObject = CoroutineScope(Dispatchers.IO).async {
            val loggingInterceptor = HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            //https://api.marketstack.com
            val retrofitInstance = Retrofit.Builder()
                .baseUrl("https://api.marketstack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            retrofitInstance.create(RetrofitDao::class.java).getData("eod","b25239ec653add689085bdaa6bd0ff44", "AAPL")
        }
        val response = deferredObject.await()
        Log.d("okhttpRepositoryRetro", response.body()?.pagination.toString())
    }
}