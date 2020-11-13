package com.example.nativeapps.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nativeapps.api.GhentApiService
import com.example.nativeapps.data.GetPharmaciesApiModel
import com.example.nativeapps.repos.PharmacyRepository
import com.example.nativeapps.util.Resource
import kotlinx.coroutines.Dispatchers

class PharmacyOverviewViewModel(private val pharmacyRepository: PharmacyRepository) : ViewModel() {

    val pharmacies: LiveData<Resource<GetPharmaciesApiModel>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(pharmacyRepository.getPharmacies())
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message))
        }
    }
}
