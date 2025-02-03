package com.example.cryptocurrencyappyt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDetailEntity
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinDto
import com.example.cryptocurrencyappyt.data.mapper.dto.CoinTypeConverters

@Database(entities = [CoinDto::class, CoinDetailEntity::class], version = 2, exportSchema = false)
@TypeConverters(CoinTypeConverters::class)
abstract class CoinDatabase : RoomDatabase() {
    abstract val coinDao: CoinDao
    abstract val coinDetailDao: CoinDetailDao
}