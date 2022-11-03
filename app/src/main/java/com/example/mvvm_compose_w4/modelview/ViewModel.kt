package com.example.mvvm_compose_w4.modelview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mvvm_compose_w4.APIConvert
import com.example.mvvm_compose_w4.DriverMessage
import com.example.mvvm_compose_w4.network.APIClient
import com.example.mvvm_compose_w4.network.ApiInterface
import com.example.mvvm_compose_w4.view.MVVDisplay
import kotlinx.coroutines.*

class ViewModel : ComponentActivity() {
    private var standignsTable: APIConvert? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //coroutine to fetch json data
        val messages = APIClient.getInstance().create(ApiInterface::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            runBlocking(Dispatchers.IO) {
                val result = messages.fetchAllPosts()
                standignsTable = result.body()
            }

            setContent { MVVDisplay(covertToDriverMessage(standignsTable)) }
        }
    }

    private fun covertToDriverMessage(original: APIConvert?): List<DriverMessage> {
        val driverList: MutableList<DriverMessage> = mutableListOf()
        if (original != null) {
            original.mRData?.standingsTable?.standingsLists?.forEach { listsItem ->
                listsItem?.driverStandings?.forEach {
                    if (it != null) {
                        driverList.add(
                            DriverMessage(
                                position = it.position?.toInt() ?: 0,
                                givenName = it.driver?.givenName!!,
                                familyName = it.driver.familyName!!,
                                team = it.constructors?.get(0)?.constructorId!!,
                                points = it.points!!.toInt()
                            )
                        )
                    }
                }
            }
        }
        return driverList
    }
}