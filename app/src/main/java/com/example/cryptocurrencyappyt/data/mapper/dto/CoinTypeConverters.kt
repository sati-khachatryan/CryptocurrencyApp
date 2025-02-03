package com.example.cryptocurrencyappyt.data.mapper.dto

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CoinTypeConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromLinks(value: Links): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toLinks(value: String): Links {
        val type = object : TypeToken<Links>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromLinksExtendedList(value: List<LinksExtended>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toLinksExtendedList(value: String): List<LinksExtended> {
        val type = object : TypeToken<List<LinksExtended>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromTagList(value: List<Tag>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toTagList(value: String): List<Tag> {
        val type = object : TypeToken<List<Tag>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromTeamList(value: List<TeamMember>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toTeamList(value: String): List<TeamMember> {
        val type = object : TypeToken<List<TeamMember>>() {}.type
        return gson.fromJson(value, type)
    }
}
