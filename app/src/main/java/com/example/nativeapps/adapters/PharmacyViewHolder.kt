package com.example.nativeapps.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.nativeapps.data.Pharmacy
import com.example.nativeapps.databinding.ListItemPharmacyBinding

class PharmacyViewHolder(private var binding: ListItemPharmacyBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(pharmacy: Pharmacy) {
        binding.pharmacy = pharmacy
    }
}
