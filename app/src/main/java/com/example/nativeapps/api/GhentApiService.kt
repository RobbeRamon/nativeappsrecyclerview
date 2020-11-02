package com.example.nativeapps.api

import com.example.nativeapps.data.GetPharmaciesApiModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://data.stad.gent/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GhentApiService {

    @GET("api/records/1.0/search/?dataset=locaties-apotheken-gent&q=&facet=gemeente&facet=postcode")
    suspend fun getPharmacies(): GetPharmaciesApiModel
}


/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object GhentApi {
    val retrofitService: GhentApiService by lazy { retrofit.create(GhentApiService::class.java) }
}