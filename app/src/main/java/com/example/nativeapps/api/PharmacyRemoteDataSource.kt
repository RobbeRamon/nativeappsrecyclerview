package com.example.nativeapps.api

class PharmacyRemoteDataSource(val apiService: GhentApiService) : BaseDataSource() {

    suspend fun getPharmacies() = getResult { apiService.getPharmacies() }
}
