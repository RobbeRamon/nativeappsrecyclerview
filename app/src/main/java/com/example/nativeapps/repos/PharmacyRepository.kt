package com.example.nativeapps.repos

import com.example.nativeapps.api.PharmacyRemoteDataSource
import com.example.nativeapps.data.GetPharmaciesApiModel
import com.example.nativeapps.util.Resource

class PharmacyRepository(val pharmacyRemoteDataSource: PharmacyRemoteDataSource) {

    suspend fun getPharmacies(): Resource<GetPharmaciesApiModel> {
        return pharmacyRemoteDataSource.getPharmacies()
    }
}
