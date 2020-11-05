package com.example.nativeapps.data

import com.squareup.moshi.Json

data class PharmacyFields(
    @Json(name = "straat")
    val street: String,
    @Json(name = "naam")
    val name: String,
    @Json(name = "postcode")
    val zip: String,
    @Json(name = "huisnr")
    val number: String,
    @Json(name = "telefoon")
    val phone: String,
    @Json(name = "gemeente")
    val city: String
)
