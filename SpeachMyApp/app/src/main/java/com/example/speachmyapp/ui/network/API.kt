package com.example.speachmyapp.ui.network

import com.example.speachmyapp.ui.recyclerViewAndRetrofit.CatFact
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("fact")
    suspend fun getFact(): Response<CatFact>

}