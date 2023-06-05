package com.example.cryptocurrency.data.remote

import com.example.cryptocurrency.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

//Define the different functions and routes we want to access from our api
interface CoinPaprikaApi {
    //get all coin
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("/v1/coins/{coinId")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto

    // get detail of coin as per id
}