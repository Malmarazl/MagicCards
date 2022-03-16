package com.example.magiccards.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceAdapter {
    private var API_SERVICE: CardService? = null
    private const val URL = "https://api.magicthegathering.io/v1/"

    fun getApiService(): CardService? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val baseUrl = URL

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