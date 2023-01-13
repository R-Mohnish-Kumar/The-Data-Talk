package com.fastestindia.thedatatalk.CoursesActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R

class CourseCertificationActivity : AppCompatActivity() {
    lateinit var backButton: ImageButton
    lateinit var certificationNameTextView: TextView
    lateinit var courseCertificationRecyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var linkArray:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_certification)
        backButton = findViewById(R.id.backImageButton)
        certificationNameTextView=findViewById(R.id.certificationNameTv)
        courseCertificationRecyclerView=findViewById(R.id.courseCertificationRecyclerView)
        courseCertificationRecyclerView.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(this)
        courseCertificationRecyclerView.layoutManager=linearLayoutManager
        backButton.setOnClickListener(View.OnClickListener {
            finish()
        })
        val certificationName=intent.getStringExtra("name")
        certificationNameTextView.text=certificationName
        val topicArrayList= intent.getSerializableExtra("topics")
        val linkArrayList= intent.getSerializableExtra("link")
        val certificationNameArrayList= intent.getSerializableExtra("certification")
        linkArray=linkArrayList as ArrayList<String>
        linkArray.removeAll(listOf("null"))
        courseCertificationRecyclerView.adapter=CourseCertificationRecyclerAdapter(applicationContext,linkArray,certificationNameArrayList as ArrayList<String>)

    }
}