package com.example.studioghiblilist.usecase


class AnimeListUseCase(private val animeRepository: com.example.studioghiblilist.data.AnimeRepository) {

    operator fun invoke() = animeRepository.getAllAnimesFromDataSource()
}