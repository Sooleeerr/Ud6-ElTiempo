package com.utad.ud6_eltiempo.weather

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.utad.ud6_eltiempo.R

import com.utad.ud6_eltiempo.data.models.DailyData
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class DailyAdapter (private val data: ArrayList<DailyData>): RecyclerView.Adapter<DailyAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.weatherDailyImg)
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(weather: DailyData) {

            Picasso.get()
                .load("http://openweathermap.org/img/wn/" + weather.weather[0].icon + "@2x.png")
                .resize(100, 100) // 100 width and 100 height
                .centerCrop() // move image to cente
                .into(img)



            itemView.findViewById<TextView>(R.id.tempRvId).text = weather.temp.day.substringBefore(".") + "º"
            itemView.findViewById<TextView>(R.id.humTextRVId).text=weather.humidity.substringBefore(".") + "%"
            itemView.findViewById<TextView>(R.id.windTextRvId).text=weather.wind_speed.substringBefore(".") +  " km/h"
            itemView.findViewById<TextView>(R.id.descripRvId).text=weather.weather[0].description
            itemView.findViewById<TextView>(R.id.maxRVId).text="Max "+weather.temp.max.substringBefore(".") + "º"
            itemView.findViewById<TextView>(R.id.minRVId).text="Min "+weather.temp.min.substringBefore(".") + "º"
            itemView.findViewById<TextView>(R.id.rainTextRvId).text=((weather.pop).toDouble()*100).toString().substringBefore(".") + "%"
            val format = SimpleDateFormat("dd 'de' MMMM")

            itemView.findViewById<TextView>(R.id.diaRvId).text = format.format(Date(weather.dt.toLong()*1000))

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daily_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


}