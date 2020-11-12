package com.example.nativeapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.nativeapps.adapters.PharmacyAdapter
import com.example.nativeapps.databinding.FragmentPharmacyOverviewBinding
import com.example.nativeapps.viewmodels.PharmacyOverviewViewModel
import org.koin.android.ext.android.inject

class PharmacyOverviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: PharmacyOverviewViewModel by inject()
        val binding = FragmentPharmacyOverviewBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val adapter = PharmacyAdapter()
        binding.adapter = adapter

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let(adapter::submitList)
        })
        return binding.root
    }
}
