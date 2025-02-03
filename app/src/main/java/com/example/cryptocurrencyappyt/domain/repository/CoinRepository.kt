package com.example.cryptocurrencyappyt.domain.repository

import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDto
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDetailDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}