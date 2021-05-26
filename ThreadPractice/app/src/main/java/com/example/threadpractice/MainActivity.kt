package com.example.threadpractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.threadpractice.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mHandler = @SuppressLint("HandlerLeak")
        object: Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val cal = Calendar.getInstance()
                val sdf = SimpleDateFormat("HH:mm:ss")
                var strTime = sdf.format(cal.time)
                binding.clock.text = strTime
            }
        }

        thread(start=true){
            while(true){
                Thread.sleep(1000)
                mHandler.sendEmptyMessage(0)
            }
        }

    }


}