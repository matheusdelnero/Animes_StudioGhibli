package com.example.studioghiblilist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studioghiblilist.api.AnimeRestApiTask
import com.example.studioghiblilist.data.AnimeDataSource
import com.example.studioghiblilist.data.AnimeRepository
import com.example.studioghiblilist.domain.Anime
import com.example.studioghiblilist.implementations.AnimeDataSourceImplementation
import com.example.studioghiblilist.usecase.AnimeListUseCase

class AnimeViewModel:ViewModel() {

    companion object{
        const val TAG = "AnimeRepository"
    }

    private val animeRestApiTask = AnimeRestApiTask()
    private val animeDataSource = AnimeDataSourceImplementation(animeRestApiTask)
    private val animeRepository = AnimeRepository(animeDataSource)
    private val animeListUseCase = AnimeListUseCase(animeRepository)

    private var _listOfAnime = MutableLiveData<List<Anime>>()
    val listOfAnime: LiveData<List<Anime>>
    get() = _listOfAnime


    fun init(){
        getAllAnimes()
    }

    fun getAllAnimes(){
        Thread{
            try {
                _listOfAnime.postValue(animeListUseCase.invoke())
            }
            catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()

    }
}