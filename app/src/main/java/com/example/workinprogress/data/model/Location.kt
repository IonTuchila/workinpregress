package com.example.workinprogress.data.model

import android.os.Parcel
import android.os.Parcelable

class Location(
    val lat: Double,
    val lng: Double,
    val label: String?,
    val address: String?,
    val image: String?,
    var currentLat: Double,
    var currentLng: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lat)
        parcel.writeDouble(lng)
        parcel.writeString(label)
        parcel.writeString(address)
        parcel.writeString(image)
        parcel.writeDouble(currentLat)
        parcel.writeDouble(currentLng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}