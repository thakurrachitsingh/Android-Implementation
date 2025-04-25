package com.example.androidimplementations

import android.app.Application
import com.example.androidimplementations.Dagger.DaggerDependencyInjectionComponent
import com.example.androidimplementations.Dagger.DependencyInjectionComponent

class MyApplication: Application() {
    lateinit var dependencyInjectionComponent: DependencyInjectionComponent
    override fun onCreate() {
        super.onCreate()
        dependencyInjectionComponent = DaggerDependencyInjectionComponent.builder().build()
    }
}