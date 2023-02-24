package com.utad.ud6_eltiempo.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.ud6_eltiempo.data.models.DailyData
import com.utad.ud6_eltiempo.data.models.LocationD
import com.utad.ud6_eltiempo.data.models.ResultData
import com.utad.ud6_eltiempo.data.remote.ApiRest
import com.utad.ud6_eltiempo.data.remote.ApiRestLatLon

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch





class LocationViewModel:ViewModel() {
    val locModel=MutableLiveData<LocationD>()
    val loading = MutableStateFlow(false)

    fun getLocationData(lat:String, long:String) {
        loading.value = true

        viewModelScope.launch {
            val response = ApiRestLatLon.service.getLocation(lat+","+long)
            if (response.isSuccessful && response.body() != null) {
                locModel.value = response.body()?.data?.get(0)!!
                Log.i("WeatherViewModel", "getWeather: ${locModel.value.toString()}")
            } else {
                Log.i("WeatherViewModel", "getWeather: ${response.errorBody()?.string()}")
            }

            loading.value = false

        }

    }
}