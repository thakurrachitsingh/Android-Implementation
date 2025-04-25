package com.example.androidimplementations.implementations.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkManager(context: Context, params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
         return performAction()
    }

    private fun performAction(): Result{
        Thread.sleep(5000)
        return Result.success()
    }
}