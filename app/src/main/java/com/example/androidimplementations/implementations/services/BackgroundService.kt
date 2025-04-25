package com.example.androidimplementations.implementations.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class BackgroundService: Service() {
    override fun onCreate() {
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread(start = true){
            var x = 0
            while(true){
                Log.d("Service", "Backgroind Service ${x++}")
                Thread.sleep(1000)
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "onDestroy is called")
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}