package com.example.cryptocurrencyappyt.data.mapper.dto

import com.example.cryptocurrencyappyt.domain.model.CoinDetail
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links?,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper?,
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}

fun CoinDetailDto.toCoinDetailEntity(): CoinDetailEntity {
    return CoinDetailEntity(
        id = id,
        description = description,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type,
        isActive = isActive,
        tags = Gson().toJson(tags),
        team = Gson().toJson(team),
        developmentStatus = developmentStatus,
        firstDataAt = firstDataAt,
        hardwareWallet = hardwareWallet,
        hashAlgorithm = hashAlgorithm,
        isNew = isNew,
        lastDataAt = lastDataAt,
        links = Gson().toJson(links),
        linksExtended = Gson().toJson(linksExtended),
        message = message,
        openSource = openSource,
        orgStructure = orgStructure,
        proofType = proofType,
        startedAt = startedAt,
        whitepaper = whitepaper,
    )
}