package com.fastestindia.thedatatalk.FunActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.R

class FunActivity : AppCompatActivity() {
    lateinit var ConcentrationMusicSlow:CardView
    lateinit var ConcentrationMusicFast:CardView
    lateinit var MeditationMusics:CardView
    lateinit var GamingCollaborations:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun)
        ConcentrationMusicSlow=findViewById(R.id.ConcentrationMusicSlow)
        ConcentrationMusicFast=findViewById(R.id.ConcentrationMusicFast)
        MeditationMusics=findViewById(R.id.MeditationMusics)
        GamingCollaborations=findViewById(R.id.GamingCollaborations)
        ConcentrationMusicSlow.setOnClickListener{
            val intent = Intent(applicationContext, FunContentViewActivity::class.java)
            intent.putExtra("Type", "Concentration Music (Slow)")
            startActivity(intent)
        }

        ConcentrationMusicFast.setOnClickListener{
            val intent = Intent(applicationContext, FunContentViewActivity::class.java)
            intent.putExtra("Type", "Concentration Music (Fast)")
            startActivity(intent)
        }

        MeditationMusics.setOnClickListener{
            val intent = Intent(applicationContext, FunContentViewActivity::class.java)
            intent.putExtra("Type", "Meditation Musics")
            startActivity(intent)
        }

        GamingCollaborations.setOnClickListener{
            val intent = Intent(applicationContext, FunContentViewActivity::class.java)
            intent.putExtra("Type", "Gaming Collaboration")
            startActivity(intent)
        }
    }
}