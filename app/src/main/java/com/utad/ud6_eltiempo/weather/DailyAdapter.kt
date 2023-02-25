package com.utad.ud6_eltiempo.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.utad.ud6_eltiempo.R

import com.utad.ud6_eltiempo.data.models.DailyData



class DailyAdapter (private val data: ArrayList<DailyData>): RecyclerView.Adapter<DailyAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.weatherDailyImg)
        fun bind(weather: DailyData) {

            Picasso.get()
                .load("http://openweathermap.org/img/wn/" + weather.weather[0].icon + "@2x.png")
                .resize(100, 100) // 100 width and 100 height
                .centerCrop() // move image to cente
                .into(img)



            itemView.findViewById<TextView>(R.id.tempDailylbl).text = weather.temp.day
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