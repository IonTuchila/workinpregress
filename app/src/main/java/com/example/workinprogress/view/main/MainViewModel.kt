package com.example.workinprogress.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workinprogress.data.response.LocationRes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    var _locations = MutableLiveData<LocationRes>()
    val locations: LiveData<LocationRes>
        get() = _locations

    init {
        getLocations()
    }

    private fun getLocations() {


        viewModelScope.launch {

            repository.getLocations().let { response ->
                if (response.isSuccessful){
                    _locations.postValue(response.body())
                }
            }
        }
    }

}