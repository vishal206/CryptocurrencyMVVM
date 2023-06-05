package com.example.cryptocurrency.domain.repository

import com.example.cryptocurrency.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency.data.remote.dto.CoinDto

//Should have one function for each API request we have
//If we have database to send data we will add functions for that too
//This interface doesn't do much, the repository in "data" will have the actual implementation
//We have this interface because this helps in the test cases
interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}