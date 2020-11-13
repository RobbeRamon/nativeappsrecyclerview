package com.example.nativeapps.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativeapps.api.GhentApiService
import com.example.nativeapps.data.Pharmacy
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData
import com.example.nativeapps.data.GetPharmaciesApiModel
import com.example.nativeapps.util.Resource

class PharmacyOverviewViewModel(private val service: GhentApiService) : ViewModel() {


    val pharmacies: LiveData<Resource<GetPharmaciesApiModel>> = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try{
            emit(Resource.success(data = service.getPharmacies()))
        }catch(exception: Exception){
            emit(Resource.error(data = null, message = exception.message))
        }
    }


}
