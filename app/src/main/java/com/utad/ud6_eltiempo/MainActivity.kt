package com.utad.ud6_eltiempo

import android.R
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.utad.ud6_eltiempo.databinding.ActivityMainBinding
import com.utad.ud6_eltiempo.weather.LocationViewModel
import com.utad.ud6_eltiempo.weather.WeatherViewModel
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), LocationListener {
    private lateinit var locationManager: LocationManager
    private lateinit var tvGpsLocation: TextView
    private var latitude: String = ""
    private var longitude: String = ""
    private lateinit var binding: ActivityMainBinding

    private val locationPermissionCode = 2

    private val weatherViewModel: WeatherViewModel by viewModels()
    private val locViewModel: LocationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        runBlocking {
            getLocation()
            locViewModel.getLocationData(latitude, longitude)
            weatherViewModel.getWeather(latitude, longitude)
        }

        locViewModel.locModel.observe(this, Observer {
            binding.locationLbl.text = it.label
        })

        weatherViewModel.currentWeather.observe(this, Observer {
            val format = SimpleDateFormat("dd 'de' MMMM, HH:mm")
            //binding.currenTimeLbl.text = format.format(Date(it.dt))
            binding.currentTimeLbl.text = format.format(Date(System.currentTimeMillis()))
            binding.CurrentTempLbl.text = it.temp.substringBefore(".") + "º"
            binding.currentHumLbl.text = it.humidity.substringBefore(".") + "%"
            binding.currentPresionLbl.text = it.pressure.substringBefore(".") + "mB"
            binding.currentSensacionLbl.text = it.feels_like.substringBefore(".") + "º"
            binding.currentVientoLbl.text = it.wind_speed.substringBefore(".") + " km/h"
            binding.currentUvLbl.text = it.uvi
            binding.currentWeatherLbl.text = it.weather[0].description

            /*val image = findViewById<View>(binding.currentWeatherIc.id) as ImageView
            Picasso.get()
                .load(imageUrl)
                .resize(100, 100) // 100 width and 100 height
                .centerCrop() // move image to cente
                .into(image)

             */

            bindUrlImage(binding.currentWeatherIc, "http://openweathermap.org/img/wn/"+it.weather[0].icon+"@2x.png")
            //binding.currentWeatherIc.setImageURI(Uri.parse("http://openweathermap.org/img/wn/10d@2x.png"))


        })


    }


    @BindingAdapter("urlImage")
    fun bindUrlImage(view: ImageView, imageUrl: String?) {
        if (imageUrl != null) {
            Picasso.get()
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(view)
        } else {
            view.setImageBitmap(null)
        }
    }


    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
        val location: Location? = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        this.latitude = location?.latitude.toString()
        this.longitude = location?.longitude.toString()
    }

    override fun onLocationChanged(location: Location) {
        //tvGpsLocation = findViewById<TextView>(R.id.locationLbl)
        //tvGpsLocation.text =            "Latitude: " + location.latitude + " , Longitude: " + location.longitude

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }


}