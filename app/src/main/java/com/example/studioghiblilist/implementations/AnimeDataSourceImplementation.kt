package com.example.studioghiblilist.implementations

import android.util.Log
import com.example.studioghiblilist.api.AnimeRestApiTask
import com.example.studioghiblilist.data.AnimeDataSource
import com.example.studioghiblilist.domain.Anime

class AnimeDataSourceImplementation(private val animeRestApiTask: AnimeRestApiTask): AnimeDataSource {

    companion object{
        const val TAG = "AnimeRepository"
    }


    private val animeList = arrayListOf<Anime>()


    override fun getAllAnimes(): List<Anime> {
        val request = animeRestApiTask.retrofitApi().GetAllAnimes().execute()

        if (request.isSuccessful) {
            request.body()?.let{
                animeList.addAll(it)
            }
        } else { request.errorBody()?.let{
            Log.d(TAG, it.toString())
        }
        }

        return animeList    }

}