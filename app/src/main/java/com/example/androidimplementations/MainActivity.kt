package com.example.androidimplementations

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.androidimplementations.Dagger.DataBindingActivity
import com.example.androidimplementations.databinding.ActivityMainBinding
import com.example.androidimplementations.implementations.databinding.FragmentOne
import com.example.androidimplementations.ui.theme.AndroidImplementationsTheme

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityLayout : ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityLayout = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 200)
        Intent(this, DataBindingActivity::class.java).also{
            startActivity(it)
        }
//        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 200)

//        mainActivityLayout.dummyText.text = "Data Set through data binding"
//        mainActivityLayout.button.setOnClickListener{
//            val fragment = FragmentOne()
//            val fm = supportFragmentManager.beginTransaction()
//            fm.replace(R.id.fragment_container, fragment).commit()
//            mainActivityLayout.visibility = View.VISIBLE
//        }
//        enableEdgeToEdge()
//
//        setContent {
//            AndroidImplementationsTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidImplementationsTheme {
        Greeting("Android")
    }
}