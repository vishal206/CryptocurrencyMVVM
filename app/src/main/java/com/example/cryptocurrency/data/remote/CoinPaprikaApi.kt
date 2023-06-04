package com.example.cryptocurrency.data.remote

import retrofit2.http.GET

//Define the different functions and routes we want to access from our api
interface CoinPaprikaApi {
    //get all coin
    @GET("/v1/coins")
    suspend fun getCoins()

    // get detail of coin as per id
}