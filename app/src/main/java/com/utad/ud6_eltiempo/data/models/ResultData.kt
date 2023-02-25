package com.utad.ud6_eltiempo.data.models
/*
    "lat": 44.34,
    "lon": 10.99,
    "timezone": "Europe/Rome",
    "timezone_offset": 3600,
*/

data class ResultData(
    val lat: String,
    val lon: String,
    val timezone: String,
    val timezone_offset: Int,
    val current: CurrentData,
    val daily: ArrayList<DailyData>
)