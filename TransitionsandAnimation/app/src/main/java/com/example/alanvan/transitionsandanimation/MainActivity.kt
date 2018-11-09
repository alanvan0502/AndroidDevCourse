package com.example.alanvan.transitionsandanimation

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.view.View
import android.util.Pair
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity: AppCompatActivity() {
    companion object {
        const val TRANSITION_CODE = "Transition Code"
        const val TRANSITION_DURATION: Long = 1000
        const val ANDROID_TRANSITION = "Android Transition"
        const val BLUE_TRANSITION = "Blue Transition"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (intent.hasExtra(TRANSITION_CODE)) {
            val transitionCode = intent.getStringExtra(TRANSITION_CODE)

            when (transitionCode) {
                "Explode" -> with(window) {
                    enterTransition = Explode()
                    enterTransition.duration = TRANSITION_DURATION
                }
                "Fade" -> with(window) {
                    enterTransition = Fade()
                    enterTransition.duration = TRANSITION_DURATION
                }
            }
        }
    }

    fun explodeAnimation(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TRANSITION_CODE, "Explode")
        with (window) {
            exitTransition = Explode()
            exitTransition.duration = TRANSITION_DURATION
        }
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    fun fadeAnimation(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TRANSITION_CODE, "Fade")
        with (window) {
            exitTransition = Fade()
            exitTransition.duration = TRANSITION_DURATION
        }
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    fun inPlaceAnimation(view: View) {
        AnimationUtils.loadAnimation(this, R.anim.animation).also { animation ->
            findViewById<ImageView>(R.id.square).startAnimation(animation)
        }
    }

    fun sharedElement(view: View) {
        val otherView = findViewById<View>(R.id.rectangle)
        val options = ActivityOptions.makeSceneTransitionAnimation(this,
            Pair.create(view, ANDROID_TRANSITION), Pair.create(otherView, BLUE_TRANSITION))

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent, options.toBundle())
    }
}