package com.fastestindia.thedatatalk.CoursesActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.R
import org.json.JSONArray
import java.nio.charset.Charset

class CourseAccessSectionActivity : AppCompatActivity() {
    lateinit var courseSectionTextView: TextView
    lateinit var backToHomePage: ImageButton
    lateinit var blogCardView: CardView
    lateinit var videoCardView: CardView
    lateinit var paidCardView: CardView
    lateinit var freeCardView: CardView

    var courseNameArray=ArrayList<String>()
    var topicArray=ArrayList<String>()
    var blogsLinkArray=ArrayList<String>()
    var videosLinkArray=ArrayList<String>()
    var paidCertificationArray=ArrayList<String>()
    var paidCertificationURLArray=ArrayList<String>()
    var freeCertificationArray=ArrayList<String>()
    var freeCertificationURLArray=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_access_section)
        blogCardView=findViewById(R.id.courseBlogCardView)
        videoCardView=findViewById(R.id.courseVideoCardView)
        paidCardView=findViewById(R.id.coursePaidCardView)
        freeCardView=findViewById(R.id.courseFreeCardView)
        courseSectionTextView=findViewById(R.id.courseSectionTitleTextView)
        backToHomePage = findViewById(R.id.backToHomePageImageButton)
        backToHomePage.setOnClickListener(View.OnClickListener {
            finish()
        })

        val intent=intent
        val courseName=intent.getStringExtra("Course")
        courseSectionTextView.text = courseName.toString()

        val json: String
        val inputStream = assets.open("courses.json")
        val size = inputStream.available()
        val bytes = ByteArray(size)
        inputStream.read(bytes)
        inputStream.close()
        val charset:Charset=Charset.forName("UTF-8")
        json = String(bytes, charset)
        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.getString("Course") == courseName) {
                topicArray.add(jsonObject.getString("Topics"))
                blogsLinkArray.add(jsonObject.getString("Blogs"))
                videosLinkArray.add(jsonObject.getString("Videos"))
                paidCertificationURLArray.add(jsonObject.getString("url"))
                paidCertificationArray.add(jsonObject.getString("Paid Certification"))
                freeCertificationURLArray.add(jsonObject.getString("url.1"))
                freeCertificationArray.add(jsonObject.getString("Free Certification"))
            }
        }

        blogCardView.setOnClickListener{
            val intent = Intent(applicationContext, CourseContentViewActivity::class.java)
            intent.putExtra("name",courseName)
            intent.putStringArrayListExtra("topics",topicArray)
            intent.putStringArrayListExtra("link",blogsLinkArray)
            intent.putStringArrayListExtra("paid",paidCertificationArray)
            intent.putStringArrayListExtra("free",freeCertificationArray)
            startActivity(intent)
        }
        videoCardView.setOnClickListener{
            val intent = Intent(applicationContext, CourseContentViewActivity::class.java)
            intent.putExtra("name",courseName)
            intent.putStringArrayListExtra("topics",topicArray)
            intent.putStringArrayListExtra("link",videosLinkArray)
            intent.putStringArrayListExtra("paid",paidCertificationArray)
            intent.putStringArrayListExtra("free",freeCertificationArray)
            startActivity(intent)
        }
        paidCardView.setOnClickListener{
            val intent = Intent(applicationContext, CourseCertificationActivity::class.java)
            intent.putExtra("name","Paid Certification")
            intent.putStringArrayListExtra("topics",topicArray)
            intent.putStringArrayListExtra("link",paidCertificationURLArray)
            intent.putStringArrayListExtra("certification",paidCertificationArray)
            startActivity(intent)
        }
        freeCardView.setOnClickListener{
            val intent = Intent(applicationContext, CourseCertificationActivity::class.java)
            intent.putExtra("name","Free Certification")
            intent.putStringArrayListExtra("topics",topicArray)
            intent.putStringArrayListExtra("link",freeCertificationURLArray)
            intent.putStringArrayListExtra("certification",freeCertificationArray)
            startActivity(intent)
        }


    }
}