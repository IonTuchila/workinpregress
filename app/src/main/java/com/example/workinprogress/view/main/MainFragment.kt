package com.example.workinprogress.view.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.workinprogress.R
import com.example.workinprogress.common.ui.BaseFragment
import com.example.workinprogress.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

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
        viewModel.locations.observe(viewLifecycleOwner, {
            (dataBinding.recyclerView.adapter as MainAdapter).submitList(it.locations)
        })
    }

    private fun setupRecycler() {
        val  snapHelper  = LinearSnapHelper()
        dataBinding.recyclerView.apply {
            snapHelper.attachToRecyclerView(this)
            this.adapter = MainAdapter { location ->

            }
        }
    }

}