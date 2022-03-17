package com.example.magiccards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    fun showSpinner(show: Boolean) {
        if (show) {
            animation_loading.visibility = View.VISIBLE
        } else {
            animation_loading.visibility = View.INVISIBLE
        }
    }


}