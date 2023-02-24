package com.utad.ud6_eltiempo.data.remote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRest {

    lateinit var service: ApiService

    val URL = "https://api.openweathermap.org/"
    val URL_IMAGES = "http://openweathermap.org/img/wn/"
    val api_key = "df754eddc9e2e8d1fe3a2b80c12e1223"
    val language = "es"
    val exclude = "minutely,hourly,alerts"
    val units="metric"

    init {
        initService()
    }

    private fun initService() {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)
    }
}