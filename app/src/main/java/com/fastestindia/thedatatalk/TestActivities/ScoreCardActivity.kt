package com.fastestindia.thedatatalk.TestActivities

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.util.DisplayMetrics
import android.view.View

class ScoreCardActivity : AppCompatActivity() {
    lateinit var totalScore: TextView
    lateinit var totalCorrect: TextView
    lateinit var totalWrong: TextView
    lateinit var exit: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_card)
        totalScore = findViewById(R.id.totalScore)
        totalCorrect = findViewById(R.id.totalCorrectAns)
        totalWrong = findViewById(R.id.totalWrongAns)
        exit = findViewById(R.id.exitButton)
        exit.setOnClickListener(View.OnClickListener { finish() })
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * 1.0).toInt(), (height * .7).toInt())
        val intent = intent
        val total = intent.getStringExtra("total")
        val correct = intent.getStringExtra("correct")
        val wrong = intent.getStringExtra("wrong")
        val outOfScore = correct!!.toInt() + wrong!!.toInt()
        totalScore.setText("$total/$outOfScore")
        totalCorrect.setText(correct)
        totalWrong.setText(wrong)
    }
}