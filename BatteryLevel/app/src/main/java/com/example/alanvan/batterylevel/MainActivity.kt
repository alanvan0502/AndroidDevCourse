package com.example.alanvan.batterylevel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    companion object {
        const val BATTERY_KEY = "BATTERY KEY"
    }

    private lateinit var batteryImage: ImageView
    private var batteryLevel = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batteryImage = findViewById(R.id.batteryImage)

        if (savedInstanceState != null) {
            batteryLevel = savedInstanceState.getInt(BATTERY_KEY)
        }

        batteryImage.drawable.level = batteryLevel
    }

    fun increaseBattery(view: View) {
        if (batteryLevel < 6) {
            batteryLevel++
            batteryImage.drawable.level = batteryLevel
        }
    }

    fun decreaseBattery(view: View) {
        if (batteryLevel > 0) {
            batteryLevel--
            batteryImage.drawable.level = batteryLevel
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt(BATTERY_KEY, batteryLevel)
        super.onSaveInstanceState(outState)
    }
}
