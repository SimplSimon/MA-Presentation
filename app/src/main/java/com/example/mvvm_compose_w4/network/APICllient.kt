package com.example.mvvm_compose_w4.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

private var BASEURL = "https://ergast.com/api/f1/${LocalDateTime.now().year}/"

class APIClient {
    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}


