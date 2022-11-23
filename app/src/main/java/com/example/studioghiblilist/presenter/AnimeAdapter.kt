package com.example.studioghiblilist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.studioghiblilist.R
import com.example.studioghiblilist.domain.Anime
import kotlinx.android.synthetic.main.anime_list_layout.view.*

class AnimeAdapter(private val animeList: List<Anime>): RecyclerView.Adapter<AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_list_layout, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.itemView.apply {
            title.text = animeList[position].title
            description.text = animeList[position].description
            imageView.load(animeList[position].image) {
                placeholder(R.drawable.ic_launcher_background)
                fallback(R.drawable.ic_launcher_background)
            }
        }
    }

    override fun getItemCount(): Int = animeList.size
}