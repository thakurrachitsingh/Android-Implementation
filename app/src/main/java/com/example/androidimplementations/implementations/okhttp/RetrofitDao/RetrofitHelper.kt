package com.example.androidimplementations.implementations.okhttp.RetrofitDao

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL = "https://api.marketstack.com"

    private var retrofit: Retrofit? = null

    private fun createInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): Retrofit{
        if(retrofit==null){
            retrofit = createInstance()
        }
        return retrofit!!
    }

}