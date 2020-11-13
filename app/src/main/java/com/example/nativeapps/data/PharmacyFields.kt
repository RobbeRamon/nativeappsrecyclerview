package com.example.nativeapps.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable
