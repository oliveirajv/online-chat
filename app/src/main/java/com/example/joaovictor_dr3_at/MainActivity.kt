package com.example.joaovictor_dr3_at

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.joaovictor_dr3_at.repository.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val retrofit = Retrofit
//            .Builder()
//            .baseUrl("https://goweather.herokuapp.com/weather/rio&de&janeiro")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val WeatherService = retrofit.create(WeatherService::class.java)
    }
}
