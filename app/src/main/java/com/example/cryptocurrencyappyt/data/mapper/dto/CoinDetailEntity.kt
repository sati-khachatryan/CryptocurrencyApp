package com.example.cryptocurrencyappyt.data.mapper.dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "coin_details_table")
data class CoinDetailEntity(
    @PrimaryKey val id: String,
    val description: String,
    val developmentStatus: String,
    val firstDataAt: String,
    val hardwareWallet: Boolean,
    val hashAlgorithm: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val lastDataAt: String,
    val message: String,
    val name: String,
    val openSource: Boolean,
    val orgStructure: String,
    val proofType: String,
    val rank: Int,
    val startedAt: String,
    val symbol: String,
    val type: String,

    @Embedded val whitepaper: Whitepaper?,

    val links: String,
    val linksExtended: String,
    val tags: String,
    val team: String
)


fun CoinDetailEntity.entityToDto(): CoinDetailDto {
    return CoinDetailDto(
        id = id,
        description = description,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type,
        isActive = isActive,
        tags = Gson().fromJson(tags, object : TypeToken<List<Tag>>() {}.type),
        team = Gson().fromJson(team, object : TypeToken<List<TeamMember>>() {}.type),
        developmentStatus = "",
        firstDataAt = "",
        hardwareWallet = false,
        hashAlgorithm = "",
        isNew = false,
        lastDataAt = "",
        links = null,
        linksExtended = emptyList(),
        message = "",
        openSource = false,
        orgStructure = "",
        proofType = "",
        startedAt = "",
        whitepaper = null,
    )
}
