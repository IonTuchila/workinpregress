package com.example.workinprogress.common.ui

import android.location.Location
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.workinprogress.R
import com.squareup.picasso.Picasso


@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean?) {
    with(view) {
        visible?.let {
            visibility = if (it) View.VISIBLE
            else View.GONE
        }
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String) {
    Picasso.get().load(url).placeholder(R.drawable.ic_placeholder).into(view)
}

@BindingAdapter("distance")
fun setDistance(view: TextView, location: com.example.workinprogress.data.model.Location) {
    val startPoint = Location("start")
    startPoint.latitude = location.currentLat;
    startPoint.longitude = location.currentLng;

    val endPoint = Location("end")
    startPoint.latitude = location.lat;
    startPoint.longitude = location.lng;

    val distance = startPoint.distanceTo(endPoint)

    view.text = "Distance: $distance m"
}