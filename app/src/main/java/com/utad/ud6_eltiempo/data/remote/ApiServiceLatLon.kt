package com.utad.ud6_eltiempo.data.remote


import com.utad.ud6_eltiempo.data.models.LocationData

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServiceLatLon {

    @GET("v1/reverse")

    suspend fun getLocation(
        @Query("query") latlon: String,
        @Query("access_key") appid: String = ApiRestLatLon.api_key,
        @Query("limit") unit: String = ApiRestLatLon.limit
    ): Response<LocationData>

}