package com.example.nativeapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        return binding.root
    }
}
