package com.example.nativeapps.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import androidx.lifecycle.viewModelScope
import com.example.nativeapps.api.GhentApiService
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class PharmacyOverviewViewModel(private val service: GhentApiService) : ViewModel() {

    private var viewModelJob = Job()
    private var _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getPharmacies()
    }

    private fun getPharmacies() {
        viewModelScope.launch {

            try {
                val result = service.getPharmacies()
                _response.value = "Success: ${result.records.size} pharmacies retrieved"
            } catch (e: Exception) {
                Log.e("Failure: ", e.message, e)
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
