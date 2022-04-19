package com.example.joaovictor_dr3_at.repository

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("https://goweather.herokuapp.com/weather/")
    fun getWeather() : Call<JsonObject>

    @GET("https://goweather.herokuapp.com/weather/")
    fun getCityWeatherInformation(
        @Path(value = "london", encoded = true) city : String
    ) : Call<JsonObject>

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
