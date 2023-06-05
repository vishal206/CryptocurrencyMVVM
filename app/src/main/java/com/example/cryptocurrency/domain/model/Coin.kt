package com.example.cryptocurrency.domain.model


//This have everything from CoinDto except type and is_new. "SerializedName is not needed
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
