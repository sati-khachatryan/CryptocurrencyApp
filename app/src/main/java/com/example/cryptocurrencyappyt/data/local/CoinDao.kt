package com.example.cryptocurrencyappyt.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDto

@Dao
interface CoinDao {
    @Upsert
    suspend fun insertAll(coins: List<CoinDto>)

    @Query("SELECT * FROM coins_table")
    suspend fun getAll(): List<CoinDto>

}