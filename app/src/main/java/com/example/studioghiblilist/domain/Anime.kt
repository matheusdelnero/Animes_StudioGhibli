package com.example.studioghiblilist.domain
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime(
    val title: String,
    val description: String,
    val image: String
): Parcelable


