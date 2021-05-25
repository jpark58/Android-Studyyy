package com.example.retrofitpractice

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int
)
