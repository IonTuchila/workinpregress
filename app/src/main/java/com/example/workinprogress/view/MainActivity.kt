package com.example.workinprogress.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workinprogress.R
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
    }
}