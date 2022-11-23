package com.example.studioghiblilist.data

import com.example.studioghiblilist.domain.Anime

interface AnimeDataSource {

    fun getAllAnimes():List<Anime>
}