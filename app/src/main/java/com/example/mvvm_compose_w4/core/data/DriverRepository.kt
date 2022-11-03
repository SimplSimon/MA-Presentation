package com.example.mvvm_compose_w4.core.data

class DriverRepository(private val dataSource: DriverDataSource) {
    fun getDrivers() = dataSource.getDrivers()
    fun updateData() = dataSource.updateData()
}