package com.example.magiccards

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.magiccards.databinding.ActivityMainBinding
import com.example.magiccards.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    fun showSpinner(show: Boolean) {
        val lottie = findViewById<LottieAnimationView>(R.id.animation_loading)

        if (show) {
            lottie.visibility = View.VISIBLE
        } else {
            lottie.visibility = View.INVISIBLE
        }
    }


}