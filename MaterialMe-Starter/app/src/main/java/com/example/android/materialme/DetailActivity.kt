package com.example.android.materialme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val sportsTitle: TextView = findViewById(R.id.detailTitle)
        val sportsImage: ImageView = findViewById(R.id.detailSportsImage)
        val subtitle: TextView = findViewById(R.id.detailSubTitle)

        sportsTitle.text = intent.getStringExtra("title")
        Glide.with(this).
                load(intent.getIntExtra("image_resource", 0)).into(sportsImage)

        // Display the correct subtitle
        val sportsList = resources
                .getStringArray(R.array.sports_titles)

        val detailSubtitles = resources
                .getStringArray(R.array.detail_subtitles)
        subtitle.text = detailSubtitles[sportsList.indexOf(sportsTitle.text)]
    }
}
