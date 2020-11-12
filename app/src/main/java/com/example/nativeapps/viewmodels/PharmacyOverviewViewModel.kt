package com.example.nativeapps.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativeapps.api.GhentApiService
import com.example.nativeapps.data.Pharmacy
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PharmacyOverviewViewModel(private val service: GhentApiService) : ViewModel() {

    private var _pharmacies = MutableLiveData<List<Pharmacy>>()
    val pharmacies: LiveData<List<Pharmacy>>
        get() = _pharmacies

    init {
        getPharmacies()
    }

    private fun getPharmacies() {
        viewModelScope.launch {
            try {
                val result = service.getPharmacies()
                _pharmacies.value = result.records
                result.records
            } catch (e: Exception) {
                Log.e("Failure: ", e.message, e)
            }
        }
    }
}
