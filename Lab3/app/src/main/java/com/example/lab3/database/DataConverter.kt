package com.example.lab3.database

import androidx.room.TypeConverter
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.lang.reflect.Type

class DataConverter {
    @TypeConverter
    fun fromUsersList(user: List<Users?>?): String? {
        if (user == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Users?>?>() {}.type
        return gson.toJson(user, type)
    }

    @TypeConverter
    fun toUsersList(countryLangString: String?): List<Users>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Users?>?>() {}.type
        return gson.fromJson(countryLangString, type)
    }
}