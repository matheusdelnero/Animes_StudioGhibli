package com.example.studioghiblilist.data

class AnimeRepository(private val animeDataSource: AnimeDataSource) {

    fun getAllAnimesFromDataSource() = animeDataSource.getAllAnimes()
}