package com.example.nourahalhindi_belt_exam2.models

import com.example.nourahalhindi_belt_exam2.models.data.ShowTV
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    //https://api.tvmaze.com/search/shows?q=girls

    @GET("shows")
    fun getshows(@Query("q") q:String):Call<ShowTV>

}