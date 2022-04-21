package com.example.speachmyapp.ui.recyclerViewAndRetrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatFact(
    @SerializedName("fact")
    @Expose
    var fact : String,
    @SerializedName("length")
    @Expose
    val length : String
)
