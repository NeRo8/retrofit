package com.example.nero.myapplication.api.models

import com.google.gson.annotations.SerializedName

data class Geo(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)