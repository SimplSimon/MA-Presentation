package com.example.mvvm_compose_w4.core.data

import androidx.lifecycle.LiveData
import com.example.mvvm_compose_w4.core.domain.DriverMessage

interface DriverDataSource {
    fun updateData()
    fun getDrivers(): LiveData<List<DriverMessage>>
}