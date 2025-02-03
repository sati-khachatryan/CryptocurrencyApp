package com.example.cryptocurrencyappyt.data.mapper.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptocurrencyappyt.domain.model.Coin
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coins_table")
data class CoinDto(
    @PrimaryKey
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String,
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )
}