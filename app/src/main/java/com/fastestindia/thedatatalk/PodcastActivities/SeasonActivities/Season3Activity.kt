package com.fastestindia.thedatatalk.PodcastActivities.SeasonActivities

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View

class Season3Activity : AppCompatActivity() {
    lateinit var s3e1: CardView
    lateinit var s3e2: CardView
    lateinit var s3e3: CardView
    lateinit var s3e4: CardView
    lateinit var s3e5: CardView
    lateinit var s3e6: CardView
    lateinit var s3e7: CardView
    lateinit var s3e8: CardView
    lateinit var s3e9: CardView
    lateinit var s3e10: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season3)
        s3e1 = findViewById(R.id.s1e1)
        s3e2 = findViewById(R.id.s1e2)
        s3e3 = findViewById(R.id.s1e3)
        s3e4 = findViewById(R.id.s1e4)
        s3e5 = findViewById(R.id.s1e5)
        s3e6 = findViewById(R.id.s1e6)
        s3e7 = findViewById(R.id.s1e7)
        s3e8 = findViewById(R.id.s1e8)
        s3e9 = findViewById(R.id.s1e9)
        s3e10 = findViewById(R.id.s1e10)
        s3e1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e01)
            intent.putExtra("title", "Shashank Kodhati")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43888170/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-01%2F7387eec06531e347d9c34274d7594771.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/26ejsb83ELkfykZpeufS50?si=KY_Xp8QGSva6_QVGvgo1dQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NDdiMGUwMjItNjIwOS00MmMzLTg3ZDctOTIzYzVlYTVlMmVm?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s03e01-life-of-data-science-professional/id1553423876?i=1000543044430"
            )
            startActivity(intent)
        })
        s3e2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e02)
            intent.putExtra("title", "Sasank Amavarapu")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43908972/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-01%2Fa161bef979f1a57c1fefe1714248c472.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/6221y5husfGTA7Gg610KJb?si=UjPQpGkMTNKdgF65LV-2Mw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YzE1NzI1YWUtZTAxZC00ZDc3LTg2NTAtY2ExZjkzZDIzZGI4?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s03e02-life-of-data-science-professional/id1553423876?i=1000543079778"
            )
            startActivity(intent)
        })
        s3e3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e03)
            intent.putExtra("title", "Samraat")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/44287828/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-30%2F36453f4683907a66b6f5d327a6bb293c.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/3PWO2U4PrZ753NM53iClLK?si=_U_hP0nCT_-nA9ip5ndm2w"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NTNmY2RkMTktYjJjYS00YjBkLWI4MDYtMjUyZTVmZDY2NjM4?sa=X&ved=2ahUKEwisiLSFlNr1AhViiNgFHXjqDE8QkfYCegQIARAF"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e03-samraat/id1553423876?i=1000543807618"
            )
            startActivity(intent)
        })
        s3e4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e04)
            intent.putExtra("title", "Shubhasree Sarkar")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/44380905/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-30%2F825e67cb56cc973d318086055098aa5f.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/4k3ovzRhKp3C5PukE9gNqq?si=zNxWCFBGQriXnRsszzR0rw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YWVmMDc4NzYtYWE0ZS00MzYyLTgyN2ItMDUwZTRmYjUzZjdh?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e04-shubhasree-sarkar/id1553423876?i=1000543980096"
            )
            startActivity(intent)
        })
        s3e5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e05)
            intent.putExtra("title", "Gourab Dasgupta")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/44849593/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-30%2Ffe009e90671e674640dd426dce2542ce.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/7xzA1y4OiFlLptaPCh1Rmw?si=2ysfToPyT9qz6Y4lEh0hxw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NmM5Yjk3ZGItOGRkMi00NGM1LTgxMzEtNTM5ZGM4ZTQ1Y2Ri?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e05-gourab-dasgupta/id1553423876?i=1000544964688"
            )
            startActivity(intent)
        })
        s3e6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e06)
            intent.putExtra("title", "Aastha Khanna")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/45070479/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-30%2F068ae8140faa60ea1af608c117ef68f6.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/2R41I2heeBIhbI7Bp6RLBb?si=M7w9Z600SZKHMYduilmA0A"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NGNmMzZhZTUtY2Y0YS00NzVjLTlmMjctZGE5MGY3YTVkYjdl?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e06-aastha-khanna/id1553423876?i=1000545499259"
            )
            startActivity(intent)
        })
        s3e7.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e07)
            intent.putExtra("title", "Aishwarya Nair")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/45479639/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-30%2F9ca03bb98513a4ccd167be87c99a193c.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/3ApF6PAt4kc6nNNMkMWt9M?si=qnFp96QdTFOGgT8jTmnX8w"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/ZWZhODA2MGQtNmMyYy00MDIzLWJlZjgtNzM4YTM2NTlmZGQ1?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e07-aishwarya-nair/id1553423876?i=1000546498519"
            )
            startActivity(intent)
        })
        s3e8.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e08)
            intent.putExtra("title", "Aakansha Dijendra")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/45488944/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-30%2F12b9b581b4f9ffb35dabb70ab918c94a.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/2mdwn3mAW0Rk78y8fI3t5a?si=7x-T9GBFRdmBwsLvO7ptvw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YzJiNTVjOTYtNWM0OS00YTE3LWEzOTMtOGNhYzQ4MjRmN2E0?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e08-aakansha-dijendra/id1553423876?i=1000546519265"
            )
            startActivity(intent)
        })
        s3e9.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e09)
            intent.putExtra("title", "Aviral Mathur")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/45518638/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-12-31%2F707601254c08236e8f600446139642cc.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/181PVEkrXO9FdS32y4zc48?si=nxynJSQEThOKiCCe8XftfA"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NDJmYjhkY2UtZmUxMC00OThkLTk0YWUtMGM2ODQ3NjhjNzEw?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsp-s03e09-aviral-mathur/id1553423876?i=1000546566434"
            )
            startActivity(intent)
        })
        s3e10.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season3Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so3e010)
            intent.putExtra("title", "Ravin Kumar")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/46196387/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fproduction%2Fexports%2F3b995eb8%2F46196387%2F8f66632b0b8bfc663dbc1a7b5f0b04fb.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/06WhMverBPUL80w9QchUQH?si=Xyukr9gOQ2-6ocwLyozEBQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/M2Q3YjY3MGQtYjA2Yi00MDAwLWJmMjAtYzkxYzNhY2JjNzQ0?sa=X&ved=0CAUQkfYCahcKEwjI7MOWlNr1AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-season-3-data-science-professional-trailer/id1553423876?i=1000548032247"
            )
            startActivity(intent)
        })
    }
}