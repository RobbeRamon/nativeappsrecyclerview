package com.example.nativeapps.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.nativeapps.model.Pharmacy
import com.example.nativeapps.repos.PharmacyRepository
import com.example.nativeapps.util.Resource

class PharmacyOverviewViewModel(private val pharmacyRepository: PharmacyRepository) : ViewModel() {

    val pharmacies: LiveData<Resource<List<Pharmacy>>> = pharmacyRepository.getPharmacies()
}
