package com.example.my_boat.ui.boats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoatsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is your boats"
    }
    val text: LiveData<String> = _text
}