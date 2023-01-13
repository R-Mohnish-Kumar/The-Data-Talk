package com.fastestindia.thedatatalk
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.TextView
import android.widget.ImageButton
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.PopupMenu
import com.fastestindia.thedatatalk.ProfileActivities.ProfileActivity
import android.widget.Toast
import com.fastestindia.thedatatalk.PodcastActivities.SeasonActivities.PodcastActivity
import com.fastestindia.thedatatalk.EventsActivities.MeetUpActivity
import com.fastestindia.thedatatalk.TestActivities.TestActivity
import com.fastestindia.thedatatalk.QueryActivities.QueryActivity
import com.fastestindia.thedatatalk.JobReferralActivities.JobReferralActivity
import com.fastestindia.thedatatalk.CollabActivities.CollabActivity
import com.fastestindia.thedatatalk.BlogActivities.BlogActivity
import com.fastestindia.thedatatalk.CoursesActivities.CoursesActivity
import com.fastestindia.thedatatalk.FunActivities.FunActivity
import com.fastestindia.thedatatalk.R
import com.fastestindia.thedatatalk.ResourceActivities.ResourcesActivity

class HomePage : AppCompatActivity() {
    lateinit var podcast: CardView
    lateinit var userName: String
    lateinit var `fun`: CardView
    lateinit var collab: CardView
    lateinit var test: CardView
    lateinit var queries: CardView
    lateinit var job_referral: CardView
    lateinit var blog: CardView
    lateinit var events: CardView
    lateinit var courses: CardView
    lateinit var resources: CardView
    lateinit var hiUserTextView: TextView
    lateinit var more: ImageButton
    lateinit var notif: ImageButton
    lateinit var sharedPrefaManager: SharedPrefaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        notif = findViewById(R.id.notificationImageButton)
        more = findViewById(R.id.moreImageButton)
        sharedPrefaManager = SharedPrefaManager(applicationContext)
        more.setOnClickListener(View.OnClickListener {
            val popupMenu = PopupMenu(this@HomePage, more)
            popupMenu.menuInflater.inflate(R.menu.more_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.telegram -> {
                        val telegram = Uri.parse("https://t.me/+aF5Oq9OF0SU5ZmM1")
                        startActivity(Intent(Intent.ACTION_VIEW, telegram))
                        true
                    }
                    R.id.discord -> {
                        val discord = Uri.parse("https://discord.gg/t2ztSpE2ax")
                        startActivity(Intent(Intent.ACTION_VIEW, discord))
                        true
                    }
                    R.id.goToProfile -> {
                        startActivity(Intent(this@HomePage, ProfileActivity::class.java))
                        true
                    }
                    R.id.logout -> {
                        sharedPrefaManager!!.logout()
                        Toast.makeText(applicationContext, "Logged Out", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@HomePage, LoginPageActivity::class.java))
                        finish()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        })
        notif.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                applicationContext,
                "Notif Activity under Development",
                Toast.LENGTH_SHORT
            ).show()
        })
        userName = sharedPrefaManager!!.user.firstname + " " + sharedPrefaManager!!.user.lastname
        hiUserTextView = findViewById(R.id.HiUserTextView)
        hiUserTextView.setText("Hi " + userName + "..!")
        podcast = findViewById(R.id.podcastCardView)
        `fun` = findViewById(R.id.funCardView)
        collab = findViewById(R.id.collabCardView)
        test = findViewById(R.id.testCardView)
        queries = findViewById(R.id.queriesCardView)
        job_referral = findViewById(R.id.jobReferralCardView)
        blog = findViewById(R.id.blogCardView)
        events = findViewById(R.id.eventsCardView)
        courses = findViewById(R.id.coursesCardView)
        resources = findViewById(R.id.resourcesCardView)
        `fun`.setOnClickListener(View.OnClickListener { })
        podcast.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    PodcastActivity::class.java
                )
            )
        })
        events.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    MeetUpActivity::class.java
                )
            )
        })
        test.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    TestActivity::class.java
                )
            )
        })
        queries.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    QueryActivity::class.java
                )
            )
        })
        job_referral.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    JobReferralActivity::class.java
                )
            )
        })
        collab.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    CollabActivity::class.java
                )
            )
        })

        blog.setOnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    BlogActivity::class.java
                )
            )
        }

        resources.setOnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    ResourcesActivity::class.java
                )
            )
        }
        courses.setOnClickListener{
            startActivity(
                Intent(
                    this@HomePage,
                    CoursesActivity::class.java)
            )
        }
        `fun`.setOnClickListener {
            startActivity(
                Intent(
                    this@HomePage,
                    FunActivity::class.java)
            )
        }
    }

}