package com.example.weatherapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_1_23233_weather.WeatherInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeather();
    }
}


private fun getWeather() {
    var apiKey = "18fd9630090fcbc5788d467c1639e8ee"
    var city = "Orgeval"
    var uri =
            "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=18fd9630090fcbc5788d467c1639e8ee=$apiKey"
    Log.i("URI", uri)

//Create a request object

    val request = Request.Builder().url(uri).build()

    //Create a client

    val client = OkHttpClient()

    //Use client object to work with request object


    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            // TODO("Not yet implemented")
            Log.i("JSON", "JSON HTTP CALL FAILED")
        }

        override fun onResponse(call: Call, response: Response) {
            // TODO("Not yet implemented")
            Log.i("JSON", "JSON HTTP CALL SUCCEEDED")
            val body = response?.body?.string()
            //  println("json loading" + body)
            //Log.i("JSON", body)

            //body


            var jsonBody = "{\"City\": " + body + "}"
            Log.i("JSON", jsonBody)

            val gson = GsonBuilder().create()
            var weatherList = gson.fromJson(jsonBody, WeatherInfo.CityWeather::class.java)

            Log.i("JSON", weatherList.sys.country)

            //runOnUiThread {
            //    recyclerStationList.adapter = StationListAdapter(stationList.stations)

            //}
        }
    })

}