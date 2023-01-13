package com.fastestindia.thedatatalk.PodcastActivities.SeasonActivities

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View

class Season1Activity : AppCompatActivity() {
    lateinit var s1e1: CardView
    lateinit var s1e2: CardView
    lateinit var s1e3: CardView
    lateinit var s1e4: CardView
    lateinit var s1e5: CardView
    lateinit var s1e6: CardView
    lateinit var s1e7: CardView
    lateinit var s1e8: CardView
    lateinit var s1e9: CardView
    lateinit var s1e10: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season1)
        s1e1 = findViewById(R.id.s1e1)
        s1e2 = findViewById(R.id.s1e2)
        s1e3 = findViewById(R.id.s1e3)
        s1e4 = findViewById(R.id.s1e4)
        s1e5 = findViewById(R.id.s1e5)
        s1e6 = findViewById(R.id.s1e6)
        s1e7 = findViewById(R.id.s1e7)
        s1e8 = findViewById(R.id.s1e8)
        s1e9 = findViewById(R.id.s1e9)
        s1e10 = findViewById(R.id.s1e10)
        s1e1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e01)
            intent.putExtra("title", "Future and Scope of Data Science")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/23171028/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-03-13%2Ff62c668c07fca0ccfbc61de64711b158.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/00sruyyBC4b54nfzFQBST2?si=sNbb9lUSTPC12bLktX9Ccg"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/Y2E0NWY0YTQtODUwNC00ZGQ0LTlkZDUtNGMyODQ4ODM3Nzcx?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s1e1-future-and-scope-of-data-science/id1553423876?i=1000508702092"
            )
            startActivity(intent)
        })
        s1e2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e02)
            intent.putExtra("title", "Role of Data Science in Telecommunication")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/28744078/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-03-13%2F46f54bef2e06b2295adc693f42140052.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/7LCMuwheEMMLX7VcNVRUKL?si=ZejVlJbcT-Ods9JJIhJYHQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/NzFhN2M4MzMtZDRkYS00MjMyLTljMzItOTEyZjY3MTc5OGE1?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s1e2-role-of-data-science/id1553423876?i=1000512671118"
            )
            startActivity(intent)
        })
        s1e3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e03)
            intent.putExtra("title", "Role of Data Science in Human Resource Management")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/29644859/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-03-25%2F8bf3e40e308147828db81d2902a5f7ba.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/1MDVKOG6p4tn5tgyUAyAcw?si=_CV9tIakSAiXxW58YB1nZw"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YmIxMjBhZGEtYzRjMy00ZTA3LWI2NmEtMjRlNTg2NWZjZWZj?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s1e3-the-role-of-data-science/id1553423876?i=1000514307053"
            )
            startActivity(intent)
        })
        s1e4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e04)
            intent.putExtra("title", "Role of Data Science in Fintech industry")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/33741321/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-05-21%2F1e8204e250ef52647d309457e6a58c31.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/1L8OlAdM3aOWqaxxN5L7kB?si=iSX2N8agSDGiuKnEiADYqA"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/YmIxMjBhZGEtYzRjMy00ZTA3LWI2NmEtMjRlNTg2NWZjZWZj?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s1e4-role-of-data-science-in-fintech-industry/id1553423876?i=1000522544452"
            )
            startActivity(intent)
        })
        s1e5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e05)
            intent.putExtra("title", "Role of Data Science in Entertainment")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/34572064/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-06-05%2F496e43484a4a8fbb8d396f91e011ecf8.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/1ps9OUfn3nulUvlefV6UJh?si=loZ6ZtqhTempGriw6cj8OA"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/ZjU5NzgzM2MtNDIxMS00ZjY4LWJmYmItNmRiMzY1ZjViN2Rk?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s1e5-role-of-data-science-in/id1553423876?i=1000524300590"
            )
            startActivity(intent)
        })
        s1e6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e06)
            intent.putExtra("title", "Role of Data Science in Block Chain & Crypto Currency")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/35334260/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-06-15%2F2778687ec6ca875614ee997232e8779d.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/3ZRDNVz00Hf6eW1D67aWKr?si=0ZSbi0IxQkyOU-T9PTaf6g"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/ZTI4MmI5NTYtMmYwNi00MjZlLWFkYWItMzllOTk0MTcwYjdi?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s1e6-role-of-data-science-in/id1553423876?i=1000525633870"
            )
            startActivity(intent)
        })
        s1e7.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e07)
            intent.putExtra("title", "Role of Data Science in Marketing & Sales")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/37053124/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-07-13%2F3bd813c965e3c72dfe54b03421cee1b8.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/6xHao1btEXNoM8hzXgEa5V?si=B6difVnGTmmx73tsBUvxaA"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/OTZkMzhlNDEtZDU3Ny00OTMxLTkzMTAtZTYyOGYzMGNmOGVl?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s01e07-role-of-data-science-in-marketing-sales/id1553423876?i=1000528650569"
            )
            startActivity(intent)
        })
        s1e8.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e08)
            intent.putExtra("title", "Role of Data Science in Healthcare & Clinical Research")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/38503145/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-08-12%2F0124cda69a146584bf282e79216d091a.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/2do5s4M2OT2huC7oxzMHre?si=xdC7OQ6BRMqn19P9247aSQ"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/OGIxMWM2YTItODQ0NC00NDUxLTgwZjMtZGEwNDdlNmU4OGFi?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s01e08-role-of-data-science-in/id1553423876?i=1000531849456"
            )
            startActivity(intent)
        })
        s1e9.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e09)
            intent.putExtra("title", "Role of Data Science in Pharmaceuticals & Drug discovery")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/38691514/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-08-12%2Fe53d8b0addd06303780c36847eeba29a.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/0vtVUg6OW2vziKGsVeyY4Q?si=glRJAfcfSCeiQOsU8SJ7Ag"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/ODEwYmIwMWQtMDM1Yi00MzY3LTg2MDMtNzgzMmIyYTFhMTk4?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s01e09-role-of-data-science/id1553423876?i=1000531850181"
            )
            startActivity(intent)
        })
        s1e10.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Season1Activity, MediaPlayerActivity::class.java)
            intent.putExtra("picture", R.drawable.so1e010)
            intent.putExtra("title", "Role of Data Science in intellectual property")
            intent.putExtra(
                "audio",
                "https://anchor.fm/s/3b995eb8/podcast/play/39163327/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2021-08-23%2Ff661f8f35e6140a4964286c3053d643c.m4a"
            )
            intent.putExtra(
                "spotify",
                "https://open.spotify.com/episode/7dMutd4ILETZxCb2SQiym1?si=0K5AHoP9SceXBpmqb-uexg"
            )
            intent.putExtra(
                "google",
                "https://podcasts.google.com/feed/aHR0cHM6Ly9hbmNob3IuZm0vcy8zYjk5NWViOC9wb2RjYXN0L3Jzcw/episode/MmZhNDRhNDAtZGFjMS00ZDkyLWE1NGEtM2FlNTk3Y2U1ODRj?sa=X&ved=0CAUQkfYCahcKEwjoy76pgsP0AhUAAAAAHQAAAAAQAQ"
            )
            intent.putExtra(
                "apple",
                "https://podcasts.apple.com/us/podcast/the-data-talk-s01e10-role-of-data-science/id1553423876?i=1000532838754"
            )
            startActivity(intent)
        })
    }
}