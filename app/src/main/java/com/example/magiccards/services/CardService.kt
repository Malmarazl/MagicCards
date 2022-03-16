package com.example.magiccards.services

import com.example.magiccards.models.Card
import com.example.magiccards.models.ListCards
import com.example.magiccards.models.ParentCard
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {
    @GET("cards")
    suspend fun getCards() : ListCards

    @GET("cards/{multiverseid}")
    suspend fun getCardID(
        @Path("multiverseid") multiverseid: String) : ParentCard
}