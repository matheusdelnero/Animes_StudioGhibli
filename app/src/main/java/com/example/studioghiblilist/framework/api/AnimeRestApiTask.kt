package com.example.studioghiblilist.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeRestApiTask {
    companion object{
        const val BASE_URL = "https://ghibliapi.herokuapp.com/"
    }

    private fun animeProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): AnimeApi = animeProvider().create(AnimeApi::class.java)
}