package com.gamesdk

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    var id: Int = 0,
    var image: Int = 0,
    var title: String = "",
    var gameUrl: String = ""
): Parcelable
