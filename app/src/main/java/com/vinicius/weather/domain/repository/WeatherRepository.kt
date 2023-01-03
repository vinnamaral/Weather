package com.vinicius.weather.domain.repository

import com.vinicius.weather.domain.util.Resource
import com.vinicius.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}