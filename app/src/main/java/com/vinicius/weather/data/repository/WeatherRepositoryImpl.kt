package com.vinicius.weather.data.repository

import com.vinicius.weather.data.mappers.toWeatherInfo
import com.vinicius.weather.data.remote.WeatherApi
import com.vinicius.weather.domain.repository.WeatherRepository
import com.vinicius.weather.domain.util.Resource
import com.vinicius.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}