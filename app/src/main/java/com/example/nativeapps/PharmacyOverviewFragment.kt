package com.example.nativeapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nativeapps.databinding.FragmentPharmacyOverviewBinding
import com.example.nativeapps.viewmodels.PharmacyOverviewViewModel

class PharmacyOverviewFragment : Fragment() {

    /**
     * Lazily initialize our [PharmacyOverviewViewModel].
     */
    private val viewModel: PharmacyOverviewViewModel by lazy {
        ViewModelProvider(this).get(PharmacyOverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPharmacyOverviewBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }
}
