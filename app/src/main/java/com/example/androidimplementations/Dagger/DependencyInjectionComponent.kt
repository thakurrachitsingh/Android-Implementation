package com.example.androidimplementations.Dagger

import dagger.Component

@Component
interface DependencyInjectionComponent {

    fun inject(activity: DataBindingActivity)
}