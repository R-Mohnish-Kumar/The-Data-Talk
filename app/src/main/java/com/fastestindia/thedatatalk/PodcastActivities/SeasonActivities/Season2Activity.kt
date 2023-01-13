package com.fastestindia.thedatatalk.PodcastActivities.SeasonActivities

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View

class Season2Activity : AppCompatActivity() {
    lateinit var s2e1: CardView
    lateinit var s2e2: CardView
    lateinit var s2e3: CardView
    lateinit var s2e4: CardView
    lateinit var s2e5: CardView
    lateinit var s2e6: CardView
    lateinit var s2e7: CardView
    lateinit var s2e8: CardView
    lateinit var s2e9: CardView
    lateinit var s2e10: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season2)
        s2e1 = findViewById(R.id.s1e1)
        s2e2 = findViewById(R.id.s1e2)
        s2e3 = findViewById(R.id.s1e3)
        s2e4 = findViewById(R.id.s1e4)
        s2e5 = findViewById(R.id.s1e5)
        s2e6 = findViewById(R.id.s1e6)
        s2e7 = findViewById(R.id.s1e7)
        s2e8 = findViewById(R.id.s1e8)
        s2e9 = findViewById(R.id.s1e9)
        s2e10 = findViewById(R.id.s1e10)
        s2e1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e01)
            intent.putExtra("title", "Understanding The Domain")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/41898729/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-10-17%2Fda5ca8fb5ccb2959fa2c4c9d6a48c2a8.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/4xhQE9CzWH8Co2tLNPNsz0?si=SoY2qAIaRlmVZBa_uUQDbg"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NjNlZWY5M2UtMTdiZC00NWU1LThhNDAtYWEwMzMyZThmNGQz?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e01-understanding-the-domain/id1553423876?i=1000538810156"
            )
            startActivity(intent)
        })
        s2e2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e02)
            intent.putExtra("title", "Supervised and Unsupervised Data")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/42022113/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-10-20%2F1a0cc928d7003d472ce35a657d38c459.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/4PBz1ThAOIwWbj1tC1wAx3?si=MJU3R0ezSD6viR-VydTumQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/M2VjZDhhN2ItNTc5My00ZGJkLWEwMGEtM2E0YmRjYTc1NDNi?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e02-supervised-and-unsupervised-data/id1553423876?i=1000539136780"
            )
            startActivity(intent)
        })
        s2e3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e03)
            intent.putExtra("title", "Maths and Statistics")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/42638770/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-01%2Fa9b75b7dbc5b98595e31a8964267dd7a.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/3LvSDz675rQzZwm7Rbs5MO?si=6vrBaZhfSSu3My2C7YqxBg"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/ZDFlMjMwNjctMmY4Ni00MTU4LWE5N2QtYTliOGNlZWVkYmZj?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e03-maths-and-statistics/id1553423876?i=1000540361613"
            )
            startActivity(intent)
        })
        s2e4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e04)
            intent.putExtra("title", "Regression and Classification")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43215624/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-12%2F239ec71ab6c935d055ed091e9f84c86b.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/2oPswWl49m05RqsPBu0M4p?si=Xo6aFNQsTFyq6Bj1UMUBCw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YTllNGY4OGEtN2FkMC00Yzc4LTk2ZjMtOGY1ODE0M2M4OGY1?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e04-regression-classification/id1553423876?i=1000541581487"
            )
            startActivity(intent)
        })
        s2e5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e05)
            intent.putExtra("title", "Python, R and Julia")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43414786/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-16%2Fdeaa60da9749a1d052ff8ceaa4e0474e.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/4UjRqe7SDvnab6lQrScXqa?si=ilTRt7IdTuypOBhEBgV3AQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/ZjNkYmNmOTEtY2E2OC00MzBmLWJlNjAtMDJhZWI2NTI2ODI3?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e05-python-r-and-julia/id1553423876?i=1000542053884"
            )
            startActivity(intent)
        })
        s2e6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e06)
            intent.putExtra("title", "Data Collection and Scraping")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43415004/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-16%2F7b169c32302b5c9be66622ab8fe922c8.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/38NVmXHbQ9YlUm4IUntTYE?si=XtkIU9dZT9e3DeFHyH_enA"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YzA0MmZhMDktODJlYi00NDdkLTg1ZmMtMjM0YjFiMGM2NmQ3?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e06-data-collection-and-scraping/id1553423876?i=1000542054127"
            )
            startActivity(intent)
        })
        s2e7.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e07)
            intent.putExtra("title", "Data Cleaning")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43415126/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-16%2F90e9ad4f658a0947c675101b5be512bb.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/3hPudw0JFHQhlff7NeF5j7?si=4xwshbVdTHy-IiFb-9c8QQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NWIzMWIxYjEtZmFiMC00M2M3LTliMTgtOWMzODc5MWI0NmVl?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e07-data-cleaning/id1553423876?i=1000542054308"
            )
            startActivity(intent)
        })
        s2e8.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e08)
            intent.putExtra("title", "Data Preprocessing")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43415262/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-16%2F058db763ea81f9411e4b251b07eb457c.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/1uQKgIvjVY1Wx54hz7o3TQ?si=rpCawsbtTOi42Z7Kf89o3w"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NGNjMjViZTMtOWQ5My00M2VmLTllMTItYmI0NWE1ZmE4ZGQy?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e08-data-preprocessing/id1553423876?i=1000542054365"
            )
            startActivity(intent)
        })
        s2e9.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e09)
            intent.putExtra("title", "Model and Evaluation metrics")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43612432/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-19%2Fcd7c4989c710350f34c41cf3caee7689.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/7F9rRed0eYBcufEvt3LOcH?si=TZ4cXzSKSZCxa-eHyiOecw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/M2NhYWM5ODgtOGE5NC00Y2VhLTgxM2QtY2E0ZDUwZjk1ZTkz?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e09-model-and-evaluation-metrics/id1553423876?i=1000542503921"
            )
            startActivity(intent)
        })
        s2e10.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season2Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so2e010)
            intent.putExtra("title", "Computer Vision")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/43620079/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-11-19%2Fc8e43342b5f3364b1b9064793698e4f0.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/1iBCdrNOfIgradu649QGyr?si=Ek_mh7gJSwai8OJy9N2M6A"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/MTE2ZDRiNDItZDQxMi00ZjkxLThhNTEtYTM5YTQ3OGYwMWYy?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/dsf-s02e10-computer-vision-nlp-metaverse/id1553423876?i=1000542505222"
            )
            startActivity(intent)
        })
    }
}