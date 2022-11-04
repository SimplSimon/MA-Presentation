package com.example.mvvm_compose_w4.core.domain

data class DriverMessage(
    val position: Int,
    val givenName: String,
    val familyName: String,
    val team: String,
    val points: Int
)
