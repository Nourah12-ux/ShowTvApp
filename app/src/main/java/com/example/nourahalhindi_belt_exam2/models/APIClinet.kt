package com.example.nourahalhindi_belt_exam2.models

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClinet {
    var gson = GsonBuilder()
        .setLenient()
        .create()

    var retrofit: Retrofit? = null
    fun getClint(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/search/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}

