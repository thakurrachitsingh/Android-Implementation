package com.example.androidimplementations.practice

interface KotlinInterface {
    val a: Int
    val b: Int
    abstract fun method1()
    fun method2() {
        println("This is a default method in an interface.")
    }

    fun method3() {
        println("This is a static method in an interface.")
    }
}