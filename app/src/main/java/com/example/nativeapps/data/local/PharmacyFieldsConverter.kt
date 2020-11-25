package com.example.nativeapps.data.local

import androidx.room.TypeConverter
import com.example.nativeapps.model.PharmacyFields
import com.google.gson.Gson

class PharmacyFieldsConverter {

    @TypeConverter
    fun stringToFields(value: String): PharmacyFields {
        return Gson().fromJson(value, PharmacyFields::class.java)
    }

    @TypeConverter
    fun playersToString(fields: PharmacyFields): String {
        return Gson().toJson(fields)
    }
}