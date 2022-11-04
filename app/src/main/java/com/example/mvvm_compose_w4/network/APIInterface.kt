package com.example.mvvm_compose_w4.network

import com.example.mvvm_compose_w4.core.data.ApiModel
import retrofit2.Response

import retrofit2.http.GET

interface ApiInterface {
    @GET("driverStandings.json")
    suspend fun fetchAllData(): Response<ApiModel>
}