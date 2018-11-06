package com.example.alanvan.scorekeeper

import android.app.UiModeManager.MODE_NIGHT_NO
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatDelegate
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val TEAM1 = "TEAM1"
        const val TEAM2 = "TEAM2"
    }
    private var team1Score = 0
    private var team2Score = 0
    private lateinit var team1TextView: TextView
    private lateinit var team2TextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        team1TextView = findViewById(R.id.score_1)
        team2TextView = findViewById(R.id.score_2)

        team1TextView.text = team1Score.toString()
        team2TextView.text = team2Score.toString()


        if (savedInstanceState != null) {
            Log.d("MainActivity", "Not null")
            Log.d("MainActivity", savedInstanceState.getString(TEAM1))
            team1TextView.text = savedInstanceState.getString(TEAM1)
            team2TextView.text = savedInstanceState.getString(TEAM2)
        }

    }

    fun increaseScore(view: View) {
        val viewId = view.id
        if (viewId == R.id.increaseTeam1) {
            team1Score++
            team1TextView.text = team1Score.toString()
        }

        else if (viewId == R.id.increaseTeam2) {
            team2Score++
            team2TextView.text = team2Score.toString()
        }

    }

    fun decreaseScore(view: View) {
        val viewId = view.id
        if (viewId == R.id.decreaseTeam1) {
            team1Score--
            team1TextView.text = team1Score.toString()
        }

        else if (viewId == R.id.decreaseTeam2) {
            team2Score--
            team2TextView.text = team2Score.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.run{
            putString(TEAM1, team1TextView.text.toString())
            putString(TEAM2, team2TextView.text.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES)
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.day_mode)
        else
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.night_mode)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.night_mode) {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }
}
