package com.example.retrofitpractice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/repos/{owner}/FloatingLayout")
    fun getRepoList(@Path("owner") user: String): Call<Response>
}