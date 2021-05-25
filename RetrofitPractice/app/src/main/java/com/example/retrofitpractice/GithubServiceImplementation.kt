package com.example.retrofitpractice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubServiceImplementation {

    private const val BASE_URL = "https://api.github.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: GitHubService = retrofit.create(GitHubService::class.java)
}