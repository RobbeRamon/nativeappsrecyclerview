package com.example.nativeapps.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.nativeapps.data.Pharmacy
import com.example.nativeapps.databinding.ListItemPharmacyBinding
import com.example.nativeapps.databinding.ListItemPharmacyBindingImpl

class PharmacyAdapter(private var pharmacyClickListener: PharmacyClickListener) :
    ListAdapter<Pharmacy, PharmacyViewHolder>(PharmacyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        return PharmacyViewHolder(
            ListItemPharmacyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        val pharmacy = getItem(position)
        holder.bindData(pharmacy)
        holder.itemView.setOnClickListener {
            pharmacyClickListener.onPharmacyClicked(
                pharmacy
            )
        }
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


interface PharmacyClickListener {
    fun onPharmacyClicked(pharmacy: Pharmacy)
}