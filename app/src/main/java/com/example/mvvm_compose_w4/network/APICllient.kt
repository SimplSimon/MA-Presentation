package com.example.mvvm_compose_w4.network

import android.os.Build
import androidx.annotation.RequiresApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
private var BASEURL = "https://ergast.com/api/f1/${LocalDateTime.now().year}/"

class APIClient {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun getInstance(): Retrofit {

            return Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}


