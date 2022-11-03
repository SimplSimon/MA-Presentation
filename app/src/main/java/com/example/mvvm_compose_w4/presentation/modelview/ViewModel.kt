package com.example.mvvm_compose_w4.presentation.modelview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mvvm_compose_w4.core.data.ApiModel
import com.example.mvvm_compose_w4.core.data.Converter
import com.example.mvvm_compose_w4.network.APIClient
import com.example.mvvm_compose_w4.network.ApiInterface
import com.example.mvvm_compose_w4.presentation.view.MVVDisplay
import kotlinx.coroutines.*

class ViewModel : ComponentActivity() {
    private var standignsTable: ApiModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //coroutine to fetch json data
        val messages = APIClient.getInstance().create(ApiInterface::class.java)
        val converter = Converter()
        GlobalScope.launch(Dispatchers.Main) {
            runBlocking(Dispatchers.IO) {
                val result = messages.fetchAllPosts()
                standignsTable = result.body()
            }

            setContent { MVVDisplay(converter.convertApiModelToDriverMessages(standignsTable)) }
        }
    }
}