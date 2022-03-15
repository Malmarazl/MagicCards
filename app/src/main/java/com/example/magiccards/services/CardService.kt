package com.example.magiccards.services

import com.example.magiccards.models.Card
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {
    @GET("cards")
    suspend fun getCard() : List<Card>

    @GET("cards/{multiverseid}")
    suspend fun getCardID(
        @Path("multiverseid") multiverseid: String) : Card
}