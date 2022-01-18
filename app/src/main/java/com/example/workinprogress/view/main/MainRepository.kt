package com.example.workinprogress.view.main

import com.example.workinprogress.net.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getLocations() = apiService.getLocations()


}