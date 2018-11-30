package com.example.nero.meteo.api.model

import com.example.nero.myapplication.api.models.Address
import com.example.nero.myapplication.api.models.Company
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("address")
    val address: Address,
    @SerializedName("company")
    val company: Company,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)