package com.example.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RoomAccess(this).insertAll(User(1, "Jin", "Park"))
        Log.d("Room", RoomAccess(this).getById(1).toString())
    }
}