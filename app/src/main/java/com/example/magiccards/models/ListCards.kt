package com.example.magiccards.models

import com.google.gson.annotations.SerializedName

data class ListCards (@SerializedName("cards") val cards: ArrayList<Card> )