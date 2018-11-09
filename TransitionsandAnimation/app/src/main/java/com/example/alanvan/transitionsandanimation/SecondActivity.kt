package com.example.alanvan.transitionsandanimation

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun sharedElement(view: View) {
        val otherView = findViewById<View>(R.id.rectangle)
        val options = ActivityOptions.makeSceneTransitionAnimation(this,
            Pair.create(view, MainActivity.ANDROID_TRANSITION), Pair.create(otherView, MainActivity.BLUE_TRANSITION))

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent, options.toBundle())
    }
}
