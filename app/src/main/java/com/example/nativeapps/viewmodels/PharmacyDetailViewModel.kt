package com.example.nativeapps.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nativeapps.data.Pharmacy

class PharmacyDetailViewModel : ViewModel() {

    private var _pharmacy = MutableLiveData<Pharmacy>()
    val pharmacy: LiveData<Pharmacy>
        get() = _pharmacy

    fun updatePharmacy(pharmacy: Pharmacy) {
        _pharmacy.value = pharmacy
    }
}
