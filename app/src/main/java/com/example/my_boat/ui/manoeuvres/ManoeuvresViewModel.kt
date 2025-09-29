package com.example.my_boat.ui.manoeuvres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManoeuvresViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Move, move, move"
    }
    val text: LiveData<String> = _text
}