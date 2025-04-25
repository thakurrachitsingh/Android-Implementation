package com.example.androidimplementations.implementations.okhttp.RetrofitDao

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitDao {
    @GET(value = "/v1/{eod}")
    suspend fun getData(@Path("eod") param: String, @Query("access_key") accessKey : String, @Query("symbols") symbols: String): Response<com.example.androidimplementations.implementations.okhttp.dataModel.Response>
}