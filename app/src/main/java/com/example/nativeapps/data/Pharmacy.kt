package com.example.nativeapps.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pharmacy(
    @Json(name = "recordid")
    val pharmacyId: String,
    val fields: PharmacyFields
): Parcelable
