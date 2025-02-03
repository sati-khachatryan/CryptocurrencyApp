package com.example.cryptocurrencyappyt.data.remote

import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDto
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}