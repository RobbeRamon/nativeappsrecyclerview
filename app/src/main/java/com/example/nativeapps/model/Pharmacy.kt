package com.example.nativeapps.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pharmacies")
data class Pharmacy(
    @PrimaryKey
    val recordid: String,
    val fields: PharmacyFields
) : Parcelable
