package com.example.androidimplementations

import androidx.fragment.app.Fragment
import com.example.androidimplementations.implementations.services.ServicesFragment
import dagger.Subcomponent

@Subcomponent
interface SubComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ServicesFragment)
}