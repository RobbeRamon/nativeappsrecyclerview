package com.example.nativeapps.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.nativeapps.databinding.ListItemPharmacyBinding
import com.example.nativeapps.model.Pharmacy

class PharmacyViewHolder(private var binding: ListItemPharmacyBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(pharmacy: Pharmacy) {
        binding.pharmacy = pharmacy
    }
}
