package com.example.cryptocurrencyappyt.data.repository

import com.example.cryptocurrencyappyt.data.local.CoinDao
import com.example.cryptocurrencyappyt.data.local.CoinDetailDao
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDetailDto
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDto
import com.example.cryptocurrencyappyt.data.mapper.dto.entityToDto
import com.example.cryptocurrencyappyt.data.mapper.dto.toCoinDetailEntity
import com.example.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinDao: CoinDao,
    private val coinDetailDao: CoinDetailDao,
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        val cachedCoins = coinDao.getAll()
        return cachedCoins.ifEmpty {
            val apiCoins = api.getCoins()
            coinDao.insertAll(apiCoins)
            apiCoins
        }
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        val cachedCoin = coinDetailDao.getCoinById(coinId)
        return if (cachedCoin != null) {
            cachedCoin.entityToDto()
        } else {
            val apiCoin = api.getCoinById(coinId)
            coinDetailDao.insertAll(apiCoin.toCoinDetailEntity())
            apiCoin
        }
    }

}