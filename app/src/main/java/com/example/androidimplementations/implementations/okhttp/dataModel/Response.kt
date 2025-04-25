package com.example.androidimplementations.implementations.okhttp.dataModel

data class Response(
    val pagination: Pagination,
    val data: List<Data>
)

data class Pagination(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val total: Int
)

data class Data(
    val open: Double,
    val high:Double,
    val low:Double,
    val close: Double,
    val volume: Double,
    val adj_high: Double,
    val adj_low: Double,
    val adj_close: Double,
    val adj_open: Double,
    val adj_volume: Long,
    val splitFactor: Long,
    val dividend: Double,
    val symbol: String,
    val exchange: String,
    val date: String
//"split_factor": 1,
)
