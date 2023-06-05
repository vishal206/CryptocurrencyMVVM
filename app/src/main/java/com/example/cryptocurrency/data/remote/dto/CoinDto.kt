package com.example.cryptocurrency.data.remote.dto

import com.example.cryptocurrency.domain.model.Coin
import com.google.gson.annotations.SerializedName
//There are some variables that we wont need (eg:is_new,type) so we use a data class that doesn't have them, so we create a
//data class in domain>model
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

//Transforming CoinDto to Coin
fun CoinDto.toCoin(): Coin {
    return Coin(
        id=id,
        isActive=isActive,
        name=name,
        rank=rank,
        symbol=symbol
    )
}