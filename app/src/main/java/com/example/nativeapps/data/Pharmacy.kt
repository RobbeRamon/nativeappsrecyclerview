package com.example.nativeapps.data

import com.squareup.moshi.Json

data class Pharmacy(

    @Json(name = "recordid")
    val pharmacyId: String,
    val fields: PharmacyFields
)
