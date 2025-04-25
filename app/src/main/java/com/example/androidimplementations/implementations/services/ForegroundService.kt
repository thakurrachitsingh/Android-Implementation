package com.example.androidimplementations.implementations.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.androidimplementations.MainActivity
import com.example.androidimplementations.R

class ForegroundService: Service() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForegroundService()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun getPendingIntent(): PendingIntent{
        val pendingIntent = Intent(this, MainActivity::class.java)
        return PendingIntent.getActivity(this, 0, pendingIntent, PendingIntent.FLAG_IMMUTABLE)
    }

    private fun startForegroundService(){
        getNotificationChannel()
        val notification = getNotificationObject()
        startForeground(111, notification)
    }
    private fun getNotificationChannel(): NotificationChannel{
        val channel = NotificationChannel("ID", "ForegroundService", NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = ContextCompat.getSystemService(this, NotificationManager::class.java)
        notificationManager!!.createNotificationChannel(channel)
        return channel
    }
    private fun getNotificationObject(): Notification {
        val notification = NotificationCompat.Builder(this, "ID")
            .setContentText("Foreground Service is running")
            .setContentTitle("Title Foreground Service")
            .setContentIntent(getPendingIntent())
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        return notification
    }
}