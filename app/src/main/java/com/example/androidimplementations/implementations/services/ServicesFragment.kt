package com.example.androidimplementations.implementations.services

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.androidimplementations.R
import com.example.androidimplementations.databinding.FragmentServicesBinding

const val x = ""
class ServicesFragment : Fragment() {
    val nullCheck : String? = null
    lateinit var dataBindingView : FragmentServicesBinding
    var intent: Intent? = null
    lateinit var workManager: WorkManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBindingView = DataBindingUtil.inflate(inflater, R.layout.fragment_services, container, false)
        return dataBindingView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBindingView.startBackgroundService.setOnClickListener{
            intent = Intent(requireContext(), BackgroundService::class.java)
            requireActivity().startService(intent)
        }
        dataBindingView.stopBackgroundService.setOnClickListener{
            requireContext().stopService(intent)
            intent = null
        }
        dataBindingView.startForegroundService.setOnClickListener{
            requireContext().startForegroundService(Intent(requireContext(), ForegroundService::class.java))
        }
        dataBindingView.stopForegroundService.setOnClickListener {
            requireContext().stopService(Intent(requireContext(), ForegroundService::class.java))
        }
        workManager = WorkManager.getInstance(requireContext())
        performAction()

    }


    private fun performAction(){
        val work = OneTimeWorkRequestBuilder<MyWorkManager>()
            .setConstraints(Constraints(NetworkType.CONNECTED))
            .build()
        workManager.enqueue(work)
        workManager.getWorkInfoByIdLiveData(work.id).observe(viewLifecycleOwner){
            if (it!=null){
                Log.d("WorkManager", "Work is ${it.state}")
            }
        }

    }

    fun add(): Int{
        return 1 + 1
    }


}