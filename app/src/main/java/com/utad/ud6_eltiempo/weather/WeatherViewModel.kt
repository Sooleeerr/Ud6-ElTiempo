package com.utad.ud6_eltiempo.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.ud6_eltiempo.data.models.*
import com.utad.ud6_eltiempo.data.remote.ApiRest
import com.utad.ud6_eltiempo.data.remote.ApiRestLatLon

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel:ViewModel() {
    //val dailyList = MutableLiveData(listOf<DailyData>())
    val dailyList = ArrayList<DailyData>()
    val currentWeather= MutableLiveData<CurrentData>()
    val loading = MutableStateFlow(false)

    fun getWeather(lat:String, long:String) {
        loading.value = true

        viewModelScope.launch {
            val response = ApiRest.service.getWeather(lat,long)
            if (response.isSuccessful && response.body() != null) {
                currentWeather.value = response.body()?.current!!
                dailyList.addAll(response.body()?.daily!!)
                Log.i("WeatherViewModel", "getWeather: ${dailyList.toString()}")
            } else {
                Log.i("WeatherViewModel", "getWeather: ${response.errorBody()?.string()}")
            }

            loading.value = false

        }

    }
}