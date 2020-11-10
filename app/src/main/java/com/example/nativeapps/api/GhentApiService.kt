package com.example.nativeapps.api

import com.example.nativeapps.data.GetPharmaciesApiModel
import retrofit2.http.GET

interface GhentApiService {

    @GET("api/records/1.0/search/?dataset=locaties-apotheken-gent&q=&facet=gemeente&facet=postcode")
    suspend fun getPharmacies(): GetPharmaciesApiModel
}
