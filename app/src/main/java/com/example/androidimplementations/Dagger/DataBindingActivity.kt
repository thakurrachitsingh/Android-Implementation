package com.example.androidimplementations.Dagger

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.androidimplementations.Dagger.room.DataBase
import com.example.androidimplementations.Dagger.room.UserEntity
import com.example.androidimplementations.MyApplication
import com.example.androidimplementations.R
import com.example.androidimplementations.databinding.ActivityDataBindingBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DataBindingActivity : Activity() {
    lateinit var activityView: ActivityDataBindingBinding
    lateinit var dependencyInjectionComponent: DependencyInjectionComponent

    @Inject
    lateinit var dataBindingViewModel :DataBindingViewModel

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityView = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        val component = (application as MyApplication).dependencyInjectionComponent
        component.inject(this)
//        val db = Room.databaseBuilder(applicationContext, DataBase::class.java, "UserDB").build()
//        GlobalScope.launch {
//            db.contactDao().insertUser(UserEntity(id = 0, name = "Rachit", age= 24, email = "my@gmail.com", phone = "1234567890"))
//        }

        activityView.dataBindingButton1.setOnClickListener {
            dataBindingViewModel.getData()
        }
    }
}