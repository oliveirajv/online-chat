package com.example.joaovictor_dr3_at.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        fun getRetrofitInstance(path: String) : Retrofit{
            return Retrofit
                .Builder()
                .baseUrl(path)
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
//    fun getWeatherService() = getInstance().create(WeatherService::class.java)
}
