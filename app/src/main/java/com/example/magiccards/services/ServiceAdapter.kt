package com.example.magiccards.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceAdapter {
    private var API_SERVICE: CardService? = null

    fun getApiService(): CardService? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val baseUrl = "https://api.magicthegathering.io/v1/"

        if (API_SERVICE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
            API_SERVICE = retrofit.create(CardService::class.java)
        }

        return API_SERVICE
    }
}