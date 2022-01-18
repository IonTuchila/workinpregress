package com.example.workinprogress.net

import com.example.workinprogress.data.model.Location
import com.example.workinprogress.data.response.LocationRes
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/locations")
    suspend fun getLocations () : Response<LocationRes>

}