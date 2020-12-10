package com.example.weatherapp

    class CityWeather
        (
        val weather: List<Weather>,
        val main: Temperature,
        val sys: Country,
        val name: String,
        val coord: Coord
        )
        class Weather(
        val main: String,
        val description: String
        )
    class Temperature(
        val temp: Float
    )
    class Country(
        val country: String
    )
    class Coord(
            val lon: Float,
            val lat: Float
    )


class WeatherJson(val list: List<CityWeather>)