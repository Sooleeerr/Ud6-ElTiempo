package com.utad.ud6_eltiempo.data.models

/*
        "dt": 1677222696,
        "sunrise": 1677218563,
        "sunset": 1677257776,
        "temp": 6.01,
        "feels_like": 4.86,
        "pressure": 1014,
        "humidity": 75,
        "dew_point": 1.92,
        "uvi": 0.22,
        "clouds": 100,
        "visibility": 10000,
        "wind_speed": 1.7,
        "wind_deg": 202,
        "wind_gust": 3.23,
        "weather": [
            {
                "id": 804,
                "main": "Clouds",
                "description": "nubes",
                "icon": "04d"
            }
        ]
 */
data class CurrentData(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: String,
    val feels_like: String,
    val pressure: String,
    val humidity: String,
    val dew_point: String,
    val uvi: String,
    val clouds: String,
    val visibility: String,
    val wind_speed: String,
    val wind_deg: String,
    val wind_gust: String,
    val weather: List<WeatherData>
)

data class WeatherData(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
)