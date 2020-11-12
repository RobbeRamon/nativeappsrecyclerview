package com.example.nativeapps.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.nativeapps.data.Pharmacy
import com.example.nativeapps.databinding.ListItemPharmacyBinding


class PharmacyAdapter: ListAdapter<Pharmacy, PharmacyViewHolder>(PharmacyDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        return PharmacyViewHolder(ListItemPharmacyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}
private class PharmacyDiffCallback : DiffUtil.ItemCallback<Pharmacy>() {
    override fun areItemsTheSame(oldItem: Pharmacy, newItem: Pharmacy): Boolean {
        return oldItem.pharmacyId == newItem.pharmacyId
    }
    override fun areContentsTheSame(oldItem: Pharmacy, newItem: Pharmacy): Boolean {
        return oldItem == newItem
    }
}

class PharmacyViewHolder(private var binding: ListItemPharmacyBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(pharmacy: Pharmacy) {
        binding.pharmacy = pharmacy
    }
}