package com.example.nativeapps.data

import com.squareup.moshi.Json
import java.io.Serializable

data class Pharmacy(
    @Json(name = "recordid")
    val pharmacyId: String,
    val fields: PharmacyFields
): Serializable
