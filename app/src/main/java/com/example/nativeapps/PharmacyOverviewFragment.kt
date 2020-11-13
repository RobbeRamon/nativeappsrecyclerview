package com.example.nativeapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.nativeapps.adapters.PharmacyAdapter
import com.example.nativeapps.adapters.PharmacyClickListener
import com.example.nativeapps.data.Pharmacy
import com.example.nativeapps.databinding.FragmentPharmacyOverviewBinding
import com.example.nativeapps.util.Resource
import com.example.nativeapps.util.Status
import com.example.nativeapps.util.Status.SUCCESS
import com.example.nativeapps.viewmodels.PharmacyOverviewViewModel
import org.koin.android.ext.android.inject

class PharmacyOverviewFragment : Fragment(), PharmacyClickListener {

    private lateinit var adapter : PharmacyAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: PharmacyOverviewViewModel by inject()
        val binding = FragmentPharmacyOverviewBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        adapter = PharmacyAdapter(this)
        binding.adapter = adapter

        viewModel.pharmacies.observe(viewLifecycleOwner, Observer {
            if(it.status == SUCCESS)
                adapter.submitList(it.data?.records)
        })

        return binding.root
    }

    override fun onPharmacyClicked(pharmacy: Pharmacy) {
        navigateToDetail(pharmacy)
    }

    private fun navigateToDetail(pharmacy: Pharmacy) {
        val directions = PharmacyOverviewFragmentDirections.actionPharmacyOverviewFragmentToPharmacyDetailFragment(pharmacy)
        findNavController().navigate(directions)
    }
}
