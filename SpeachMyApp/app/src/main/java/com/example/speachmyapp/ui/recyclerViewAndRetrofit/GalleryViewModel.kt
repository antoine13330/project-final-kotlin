package com.example.speachmyapp.ui.recyclerViewAndRetrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is recyclerViewAndRetrofit Fragment"
    }
    val text: LiveData<String> = _text
}