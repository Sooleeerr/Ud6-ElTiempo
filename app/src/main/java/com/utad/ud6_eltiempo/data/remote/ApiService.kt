package com.utad.ud6_eltiempo.data.remote


import com.utad.ud6_eltiempo.data.models.ResultData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/3.0/onecall")

    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = ApiRest.api_key,
        @Query("exclude") exclude: String = ApiRest.exclude,
        @Query("units") unit: String = ApiRest.units,
        @Query("lang") lang: String = ApiRest.language
    ): Response<ResultData>

}

