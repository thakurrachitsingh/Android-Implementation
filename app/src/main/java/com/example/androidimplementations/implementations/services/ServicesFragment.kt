package com.example.androidimplementations.implementations.services

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.androidimplementations.DaggerAppComponent
import com.example.androidimplementations.MainActivity
import com.example.androidimplementations.MyApplication
import com.example.androidimplementations.R
import com.example.androidimplementations.databinding.FragmentServicesBinding
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val x = ""
class ServicesFragment : Fragment() {
    val nullCheck : String? = null
    lateinit var dataBindingView : FragmentServicesBinding
    var intent: Intent? = null
    lateinit var workManager: WorkManager

    @Inject
    lateinit var vm : TempViewModal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBindingView = DataBindingUtil.inflate(inflater, R.layout.fragment_services, container, false)
        return dataBindingView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comp = (requireActivity().application as MyApplication).appComponent.subComponent().inject(this)
//        val vm : TempViewModal = ViewModelProvider(requireActivity()).get(TempViewModal::class.java)
//        Log.d("ViewModel", "Data is ${vm.data.value} id: ${System.identityHashCode(vm)}")

//        val component = DaggerAppComponent.builder().build().inject(this)
//        Log.d("ViewModel", "Data is ${vm.data.value} id: ${System.identityHashCode(vm)}")

        dataBindingView.startBackgroundService.setOnClickListener{
            requireContext().startService(Intent(requireContext(), BackgroundService::class.java))


//            intent = Intent(requireContext(), BackgroundService::class.java)
//            requireActivity().startService(intent)
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
//        val work = OneTimeWorkRequestBuilder<MyWorkManager>()
//            .setConstraints(Constraints(NetworkType.CONNECTED))
//            .build()
////        workManager.enqueue(work)
//        workManager.getWorkInfoByIdLiveData(work.id).observe(viewLifecycleOwner){
//            if (it!=null){
//                Log.d("WorkManager", "Work is ${it.state}")
//            }
//        }

        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val periodicWork = PeriodicWorkRequestBuilder<MyWorkManager>(30, TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()
        workManager.enqueue(periodicWork)
        workManager.getWorkInfoByIdLiveData(periodicWork.id).observe(viewLifecycleOwner){
            if (it!=null){
                Log.d("WorkManager", "Periodic Work is ${it.state}")
            }
        }

    }

    fun add(): Int{
        return 1 + 1
    }


}