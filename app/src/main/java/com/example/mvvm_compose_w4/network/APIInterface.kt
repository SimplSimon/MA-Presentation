package com.example.mvvm_compose_w4.network

import com.example.mvvm_compose_w4.APIConvert
import com.example.mvvm_compose_w4.DriverMessage
import com.example.mvvm_compose_w4.DriverStandingsItem
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET

interface ApiInterface {
    @GET("driverStandings.json")
    suspend fun fetchAllPosts(): Response<APIConvert>
}