package com.example.my_boat.ui.maintenance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MaintenanceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Let's repair!"
    }
    val text: LiveData<String> = _text
}