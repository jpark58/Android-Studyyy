package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel: ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}