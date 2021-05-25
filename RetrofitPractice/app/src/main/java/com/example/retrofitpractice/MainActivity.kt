package com.example.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = GithubServiceImplementation.service.getRepoList("jpark58")

        call.enqueue(object: Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Log.d("jj", response.body()?.name.toString())
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("jj", t.message.toString())
            }

        })
    }
}