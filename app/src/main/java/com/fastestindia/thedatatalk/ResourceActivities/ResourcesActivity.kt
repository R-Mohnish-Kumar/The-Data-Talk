package com.fastestindia.thedatatalk.ResourceActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.HomePage
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.WebViewActivity

class ResourcesActivity : AppCompatActivity() {
    lateinit var backToHomePage: ImageButton
    lateinit var models: CardView
    lateinit var cmPapers: CardView
    lateinit var paPapers: CardView
    lateinit var cmPatents: CardView
    lateinit var paPatents: CardView
    lateinit var projects: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resources)
        models=findViewById(R.id.modelsCardView)
        cmPapers=findViewById(R.id.cmPapersCardView)
        paPapers=findViewById(R.id.paPapersCardView)
        cmPatents=findViewById(R.id.cmPatentsCardView)
        paPatents=findViewById(R.id.paPatentsCardView)
        projects=findViewById(R.id.resourceProjectCardView)

        backToHomePage = findViewById(R.id.backToHomePageImageButton)
        backToHomePage.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, HomePage::class.java))
            finish()
        })

        models.setOnClickListener{
            startActivity(Intent(
                this,
                ResourceDataActivity::class.java
            ))
        }
        cmPatents.setOnClickListener {
            val intent:Intent= Intent(applicationContext, WebViewActivity::class.java)
            intent.putExtra("url","https://github.com/thedatatalk/patent")
            startActivity(intent)
        }
        paPatents.setOnClickListener {
            val intent:Intent= Intent(applicationContext, WebViewActivity::class.java)
            intent.putExtra("url","https://github.com/thedatatalk/patents")
            startActivity(intent)
        }
        cmPapers.setOnClickListener {
            val intent:Intent= Intent(applicationContext, WebViewActivity::class.java)
            intent.putExtra("url","https://github.com/thedatatalk/paper")
            startActivity(intent)
        }
        paPapers.setOnClickListener {
            val intent:Intent= Intent(applicationContext, WebViewActivity::class.java)
            intent.putExtra("url","https://github.com/thedatatalk/papers")
            startActivity(intent)
        }
        projects.setOnClickListener {
            val intent:Intent= Intent(applicationContext, WebViewActivity::class.java)
            intent.putExtra("url","https://github.com/thedatatalk/projects")
            startActivity(intent)
        }
    }
}