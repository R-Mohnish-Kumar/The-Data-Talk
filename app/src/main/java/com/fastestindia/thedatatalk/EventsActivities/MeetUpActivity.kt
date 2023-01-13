package com.fastestindia.thedatatalk.EventsActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button

class MeetUpActivity : AppCompatActivity() {
    lateinit var joinMeet: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meet_up)
        joinMeet = findViewById(R.id.buttonjoin)
        joinMeet.setOnClickListener(View.OnClickListener {
            val meet = Uri.parse("https://meet.google.com/ujh-ssoq-ahc")
            startActivity(Intent(Intent.ACTION_VIEW, meet))
        })
    }
}