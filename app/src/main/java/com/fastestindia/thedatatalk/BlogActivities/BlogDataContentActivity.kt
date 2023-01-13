package com.fastestindia.thedatatalk.BlogActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.fastestindia.thedatatalk.HomePage
import com.fastestindia.thedatatalk.R
import java.net.URLEncoder

class BlogDataContentActivity : AppCompatActivity() {
    lateinit var backButton: ImageButton
    lateinit var homeButton: ImageButton
    lateinit var blogTitle:TextView
    lateinit var blogDesc:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_data_content)
        window.statusBarColor = resources.getColor(R.color.flouroscent_green)
        blogDesc=findViewById(R.id.blogDescriptionTextView)
        blogTitle=findViewById(R.id.blogTitleTextView)
        homeButton=findViewById(R.id.backToHomePageImageButton)
        homeButton.setOnClickListener {
            startActivity(Intent(applicationContext,HomePage::class.java))
            finish()
        }
        backButton = findViewById(R.id.backImageButton)
        backButton.setOnClickListener(View.OnClickListener {
            finish()
        })
        val title=intent.getStringExtra("title")
        val desc=intent.getStringExtra("description")
        val htmlString:Spanned=Html.fromHtml(desc)
        val htmlDesc=URLEncoder.encode(intent.getStringExtra("description"),"UTF-8")
        blogTitle.text=title.toString()
        blogDesc.text=htmlString
        blogDesc.movementMethod=ScrollingMovementMethod()
        blogDesc.movementMethod=LinkMovementMethod.getInstance()
    }
}