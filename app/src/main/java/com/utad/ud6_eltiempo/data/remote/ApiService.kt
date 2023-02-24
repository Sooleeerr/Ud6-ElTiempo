package com.utad.ud6_eltiempo.data.remote

import com.example.tema18.data.models.GenresResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/3.0/onecall")
    //suspend fun getGenres(
    suspend fun getWeather(
        @Query("lat") apikey: String = ApiRest.api_key,
        @Query("appid") apikey: String = ApiRest.api_key,
        @Query("appid") apikey: String = ApiRest.api_key,
        @Query("appid") apikey: String = ApiRest.api_key,
        @Query("appid") apikey: String = ApiRest.api_key,
        @Query("lang") language: String = ApiRest.language
    ): Response<GenresResponse>

}