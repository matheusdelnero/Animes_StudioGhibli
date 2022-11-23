package com.example.studioghiblilist.api

import com.example.studioghiblilist.domain.Anime
import retrofit2.Call
import retrofit2.http.GET

interface AnimeApi {

    @GET("films")
    fun GetAllAnimes(): Call<List<Anime>>
}