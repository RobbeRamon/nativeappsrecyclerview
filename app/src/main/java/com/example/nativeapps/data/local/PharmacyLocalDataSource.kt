package com.example.nativeapps.data.local

import com.example.nativeapps.model.Pharmacy

class PharmacyLocalDataSource(val pharmacyDao: PharmacyDao) {

    fun getPharmacies() = pharmacyDao.getAllPharmacies()

    fun getPharmacy(id: String) = pharmacyDao.getPharmacy(id)

    fun savePharmacies(list: List<Pharmacy>) = pharmacyDao.insertAll(list)
}
