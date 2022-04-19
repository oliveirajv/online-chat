package com.example.joaovictor_dr3_at.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        fun getRetrofitInstance() : Retrofit{
            return Retrofit
                .Builder()
                .baseUrl("https://goweather.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

//    private var instance: Retrofit? = null
//
//    private fun getInstance(): Retrofit {
//        if(instance == null)
//            instance = Retrofit
//                .Builder()
//                .baseUrl("https://goweather.herokuapp.com/weather/rio&de&janeiro")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        return instance as Retrofit
//    }
//
    fun getWeatherService() = getRetrofitInstance().create(WeatherService::class.java)
}
