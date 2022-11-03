package com.example.mvvm_compose_w4.presentation.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.Observer
import com.example.mvvm_compose_w4.dataSource.OnlineDriverDataSource
import com.example.mvvm_compose_w4.presentation.view.MVVDisplay

class ViewModel : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = OnlineDriverDataSource()
        setContent {
            var drivers by remember { mutableStateOf(dataSource.getDrivers().value!!) }
            dataSource.getDrivers().observe(this, Observer {
                drivers = it
            })
            dataSource.updateData()
            MVVDisplay(drivers)
        }

    }
}
