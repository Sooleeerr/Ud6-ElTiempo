package com.utad.ud6_eltiempo.data.remote
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiRest {

    lateinit var service: ApiService

    val URL = "https://api.openweathermap.org/"

    val api_key = "df754eddc9e2e8d1fe3a2b80c12e1223"
    val language = "es"
    val exclude = "minutely,hourly,alerts"
    val units="metric"


    init {
        initService()

    }

    fun initService() {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(ApiService::class.java)
    }
}

object ApiRestLatLon {

    lateinit var service: ApiServiceLatLon

    val URL = "http://api.positionstack.com/"

    val api_key = "0f94ac9eab4fe5673bd6ea1a550f7f2a"
    val limit = "1"


    init {
        initService()

    }

    fun initService() {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(ApiServiceLatLon::class.java)
    }
}