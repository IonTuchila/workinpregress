package com.example.workinprogress.view.detail

import android.os.Bundle
import android.view.View
import com.example.workinprogress.R
import com.example.workinprogress.common.Constants
import com.example.workinprogress.common.ui.BaseFragment
import com.example.workinprogress.data.model.Location
import com.example.workinprogress.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private lateinit var location: Location
    override val layoutRes = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        location = arguments?.getParcelable<Location>(Constants.LOCATION_KEY) as Location
        dataBinding.data = location
    }

}