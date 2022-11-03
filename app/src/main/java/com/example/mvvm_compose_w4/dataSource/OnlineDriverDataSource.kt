package com.example.mvvm_compose_w4.dataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_compose_w4.core.data.ApiModel
import com.example.mvvm_compose_w4.core.data.Converter
import com.example.mvvm_compose_w4.core.data.DemoData
import com.example.mvvm_compose_w4.core.data.DriverDataSource
import com.example.mvvm_compose_w4.core.domain.DriverMessage
import com.example.mvvm_compose_w4.network.APIClient
import com.example.mvvm_compose_w4.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class OnlineDriverDataSource: DriverDataSource {
    private var _drivers = MutableLiveData<List<DriverMessage>>()

    init {
        _drivers = MutableLiveData(DemoData.create(12, "Demo", "Name"))
    }

    //coroutine to fetch json data
    override fun updateData() {
        val messages = APIClient.getInstance().create(ApiInterface::class.java)
        var result: ApiModel?
        GlobalScope.launch(Dispatchers.Main) {
            runBlocking(Dispatchers.IO) {
                result = messages.fetchAllData().body()
            }
            if (result != null) {
                _drivers.value = Converter.convertApiModelToDriverMessages(result)
            }
        }
    }

    override fun getDrivers(): LiveData<List<DriverMessage>> {
        return _drivers
    }
}