package com.example.joaovictor_dr3_at

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.joaovictor_dr3_at.repository.ApiClient
import com.example.joaovictor_dr3_at.repository.WeatherService
import com.google.gson.JsonObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeather()
    }

    fun getWeather(){
        val retrofitClient = ApiClient
            .getRetrofitInstance("https://goweather.herokuapp.com/weather/{city}")

        val weatherService = retrofitClient.create(WeatherService::class.java)

        weatherService.getWeather().enqueue(object : retrofit2.Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var data = mutableListOf<String>()

                response.body()?.keySet()?.iterator()?.forEach {
                    data.add(it)
                }

                println(data.count())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d("WEATHER_API", "Não funcionou.")
            }
        })
    }
}
