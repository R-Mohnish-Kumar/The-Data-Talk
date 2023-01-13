package com.fastestindia.thedatatalk.CoursesActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R

class CourseContentViewActivity : AppCompatActivity() {
    lateinit var backButton: ImageButton
    lateinit var courseNameTextView: TextView
    lateinit var courseContentRecyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_content_view)
        backButton = findViewById(R.id.backImageButton)
        courseNameTextView=findViewById(R.id.courseNameTv)
        courseContentRecyclerView=findViewById(R.id.courseContentRecyclerView)
        courseContentRecyclerView.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(this)
        courseContentRecyclerView.layoutManager=linearLayoutManager
        backButton.setOnClickListener(View.OnClickListener {
            finish()
        })
        val courseName=intent.getStringExtra("name")
        courseNameTextView.text=courseName
        val topicArrayList= intent.getSerializableExtra("topics")
        val linkArrayList= intent.getSerializableExtra("link")
        val paidNameArrayList= intent.getSerializableExtra("paid")
        val freeNameArrayList= intent.getSerializableExtra("free")
        Log.e("Topics",topicArrayList.toString())
        Log.e("Links",linkArrayList.toString())
        courseContentRecyclerView.adapter=CoursesRecyclerAdapter(applicationContext,
            topicArrayList as ArrayList<String>, linkArrayList as ArrayList<String>,paidNameArrayList as ArrayList<String>,
            freeNameArrayList as ArrayList<String>
        )
    }
}