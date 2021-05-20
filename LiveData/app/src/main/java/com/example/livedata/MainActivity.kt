package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myNum: MutableLiveData<Int> = MutableLiveData()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        myNum.value = 0

        myNum.observe(this, Observer {
            binding.numberTv.text = it.toString()
        })

        binding.plusBtn.setOnClickListener {
            var temp = myNum
            myNum.value = temp.value?.plus(1)
        }

        binding.minusBtn.setOnClickListener {
            var temp = myNum
            myNum.value = temp.value?.minus(1)
        }
    }
}