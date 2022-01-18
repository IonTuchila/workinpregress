package com.example.workinprogress.view.main

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.workinprogress.R
import com.example.workinprogress.common.Constants.LOCATION_KEY
import com.example.workinprogress.common.ui.BaseFragment
import com.example.workinprogress.data.response.LocationRes
import com.example.workinprogress.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    override val layoutRes = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUI()
        setupRecycler()
        dataBinding.viewModel = viewModel
    }

    private fun subscribeUI() {
        viewModel.locations.observe(viewLifecycleOwner, { data ->
            (dataBinding.recyclerView.adapter as MainAdapter).submitList(data.locations)
        })
    }

    private fun setupRecycler() {
        val snapHelper = LinearSnapHelper()
        dataBinding.recyclerView.apply {
            snapHelper.attachToRecyclerView(this)
            this.adapter = MainAdapter { location ->
                val bundle = bundleOf(LOCATION_KEY to location)
                findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
            }
        }
    }

}