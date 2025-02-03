package com.example.cryptocurrencyappyt.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDetailEntity

@Dao
interface CoinDetailDao {

    @Upsert
    suspend fun insertAll(coinDetail: CoinDetailEntity)

    @Query("SELECT * FROM coin_details_table  WHERE id = :coinId")
    suspend fun getCoinById(coinId: String): CoinDetailEntity?

}