package com.example.nativeapps.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nativeapps.model.Pharmacy

@Dao
interface PharmacyDao {

    @Query("select * from pharmacies")
    fun getAllPharmacies(): LiveData<List<Pharmacy>>

    @Query("select * from pharmacies where recordid=:id")
    fun getPharmacy(id: String): LiveData<Pharmacy>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Pharmacy>)
}
