package com.fastestindia.thedatatalk.PodcastActivities.SeasonActivities

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.ImageButton
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import com.fastestindia.thedatatalk.HomePage

class PodcastActivity : AppCompatActivity() {
    lateinit var season1CardView: CardView
    lateinit var season2CardView: CardView
    lateinit var season3CardView: CardView
    lateinit var backToHomePage: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast)
        season1CardView = findViewById(R.id.season1CardView)
        season2CardView = findViewById(R.id.season2CardView)
        season3CardView = findViewById(R.id.season3CardView)
        backToHomePage = findViewById(R.id.backToHomePageImageButton)
        backToHomePage.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@PodcastActivity, HomePage::class.java))
            finish()
        })
        season1CardView.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@PodcastActivity,
                    Season1Activity::class.java
                )
            )
        })
        season2CardView.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@PodcastActivity,
                    Season2Activity::class.java
                )
            )
        })
        season3CardView.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@PodcastActivity,
                    Season3Activity::class.java
                )
            )
        })
    }
}