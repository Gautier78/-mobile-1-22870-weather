package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycler_detail.*

class RecyclerDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_detail)

        val title = intent.getStringExtra(CustomViewHolder.DETAIL_TITLE_KEY)
        supportActionBar?.title = title

        weather.text = "Weather is " + intent.getStringExtra(CustomViewHolder.Country_description)
        kelvin.text = intent.getStringExtra(CustomViewHolder.Country_temp) + " K"
        country.text = intent.getStringExtra(CustomViewHolder.Country_name)
        lon.text = intent.getStringExtra(CustomViewHolder.Country_lon)
        lat.text = intent.getStringExtra(CustomViewHolder.Country_lat)

    }
}
