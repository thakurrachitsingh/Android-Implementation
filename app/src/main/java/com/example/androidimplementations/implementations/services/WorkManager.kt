package com.example.androidimplementations.implementations.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MyWorkManager(context: Context, params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
        val job = CoroutineScope(Dispatchers.IO).async {
            performAction()
        }
         return Result.success()
    }

    private fun performAction(): Result{
        return Result.success()
    }
}