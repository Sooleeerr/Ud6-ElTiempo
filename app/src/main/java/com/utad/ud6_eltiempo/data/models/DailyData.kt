package com.utad.ud6_eltiempo.data.models
/*
 "daily": [
        {
            "dt": 1677236400,
            "sunrise": 1677218563,
            "sunset": 1677257776,
            "moonrise": 1677226140,
            "moonset": 1677276960,
            "moon_phase": 0.15,
            "temp": {
                "day": 9.75,
                "min": 5.23,
                "max": 10.95,
                "night": 7.24,
                "eve": 7.79,
                "morn": 5.6
            },
            "feels_like": {
                "day": 9.75,
                "night": 7.24,
                "eve": 7.79,
                "morn": 4.32
            },
            "pressure": 1012,
            "humidity": 64,
            "dew_point": 3.27,
            "wind_speed": 1.86,
            "wind_deg": 207,
            "wind_gust": 4.33,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "nubes",
                    "icon": "04d"
                }
            ],
            "clouds": 92,
            "pop": 0.09,
            "uvi": 1.98
        },
 */

data class DailyData(
    val dailyData: List<Daily>
)
data class Daily (
    val dt:Long,
    val sunrise:Long,
    val sunset:Long,
    val moonrise:Long,
    val moonset:Long,
    val moon_phase:String,
    val temp : TempData,
    val feels_like: FeelsLikeData,
    val pressure:String,
    val humidity:String,
    val dew_point:String,
    val wind_speed:String,
    val wind_deg:String,
    val wind_gust:String,
    val weather:List<WeatherData>,
    val clouds:String,
    val pop:String,
    val uvi:String
    )


data class TempData(
    val day:String,
    val min:String,
    val max:String,
    val night:String,
    val eve:String,
    val morn:String
)

data class FeelsLikeData(
    val day:String,
    val night:String,
    val eve:String,
    val morn:String
)
