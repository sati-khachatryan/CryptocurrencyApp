package com.example.cryptocurrencyappyt.di

import android.content.Context
import androidx.room.Room
import com.example.cryptocurrencyappyt.common.Constants
import com.example.cryptocurrencyappyt.data.local.CoinDao
import com.example.cryptocurrencyappyt.data.local.CoinDatabase
import com.example.cryptocurrencyappyt.data.local.CoinDetailDao
import com.example.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencyappyt.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(
        dao: CoinDao,
        coinDetailDao: CoinDetailDao,
        api: CoinPaprikaApi
    ): CoinRepository {
        return CoinRepositoryImpl(dao, coinDetailDao, api)
    }

    @Provides
    @Singleton
    fun provideCoinDatabase(@ApplicationContext context: Context): CoinDatabase {
        return Room.databaseBuilder(
            context,
            CoinDatabase::class.java,
            "coin_database"
        ).build()
    }

    @Provides
    fun provideCoinDao(coinDatabase: CoinDatabase): CoinDao {
        return coinDatabase.coinDao
    }

    @Provides
    fun provideCoinDetailDao(coinDatabase: CoinDatabase): CoinDetailDao {
        return coinDatabase.coinDetailDao
    }
}