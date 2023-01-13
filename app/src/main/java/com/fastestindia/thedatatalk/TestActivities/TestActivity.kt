package com.fastestindia.thedatatalk.TestActivities

import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import com.google.android.material.tabs.TabLayout
import androidx.viewpager2.widget.ViewPager2
import android.os.Bundle
import android.view.View
import com.fastestindia.thedatatalk.R
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy

class TestActivity : AppCompatActivity() {
    lateinit var pagerAdapter: PagerAdapter
    lateinit var back: ImageButton
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    var title = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        viewPager2 = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        pagerAdapter = PagerAdapter(this)
        viewPager2.setAdapter(pagerAdapter)
        back = findViewById(R.id.backImageButton)
        back.setOnClickListener(View.OnClickListener { finish() })
        TabLayoutMediator(tabLayout, viewPager2,
            TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                tab.text = title[position]
            }).attach()
    }
}