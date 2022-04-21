package com.example.speachmyapp.ui.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitBuilder {
    private val url = "https://catfact.ninja/"
    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
    private val builder : Retrofit.Builder = Retrofit.Builder().baseUrl(url)
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .client(okHttp.build())
    private val retrofit : Retrofit = builder.build()

    fun <T> buildService(serviceType : Class<T>) : T {
        return retrofit.create(serviceType)
    }

}