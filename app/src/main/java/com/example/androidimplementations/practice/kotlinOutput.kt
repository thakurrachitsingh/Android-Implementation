package com.example.androidimplementations.practice

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Main {
    lateinit var kotlinOne : JavaInterface

    fun main(args : Array<String>){
        kotlinOne = kotlinImplementation()
        kotlinOne.method1()
        CoroutineScope(Dispatchers.IO).async{

        }
    }
}