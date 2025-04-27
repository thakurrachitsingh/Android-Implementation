package com.example.androidimplementations

import com.example.androidimplementations.implementations.services.ServicesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    fun subComponent(): SubComponent


    fun inject(activity: MainActivity)

    fun inject(fragment: ServicesFragment)

}