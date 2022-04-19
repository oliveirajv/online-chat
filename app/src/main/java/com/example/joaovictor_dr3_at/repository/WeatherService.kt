package com.example.joaovictor_dr3_at.repository

import com.example.joaovictor_dr3_at.Weather
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("/weather/{city}")
    suspend fun getWeather() : Weather

    @GET("/weather/{city}")
    suspend fun getCityWeatherInformation(
        @Path(value = "city") city : String = "rio"
    ) : Weather

    //    @GET("https://goweather.herokuapp.com/weather/{city}")
//    suspend fun list(
//        @Path("rio&de&janeiro") city: String
//    ): WeatherService

    //inserir/insert


    //selecionar um/select one


    //selecionar todos/select all


    //atualizar/update


    //deletar/delete


}
