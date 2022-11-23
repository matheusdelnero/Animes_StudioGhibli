package com.example.studioghiblilist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.studioghiblilist.R
import com.example.studioghiblilist.domain.Anime
import com.example.studioghiblilist.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var animeViewModel: AnimeViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        animeViewModel = ViewModelProvider.NewInstanceFactory().create(AnimeViewModel::class.java)
        animeViewModel.init()
        initObserver()
        loadingVisibility(true)


    }

    private fun initObserver() {
        animeViewModel.listOfAnime.observe(this,{ list ->
            if (list.isNotEmpty()){
                populateList(list)
                loadingVisibility(false)
            }

        })
    }

    private fun populateList(list: List<Anime>) {
        animeRecycler.apply {
            hasFixedSize()
            adapter = AnimeAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

}