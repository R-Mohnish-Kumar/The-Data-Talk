package com.fastestindia.thedatatalk.TestActivities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    var title = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TestSectionFragment1()
            1 -> return TestSectionFragment2()
            2 -> return TestSectionFragment3()
            3 -> return TestSectionFragment4()
            4 -> return TestSectionFragment5()
            5 -> return TestSectionFragment6()
            6 -> return TestSectionFragment7()
            7 -> return TestSectionFragment8()
        }
        return TestSectionFragment1()
    }

    override fun getItemCount(): Int {
        return title.size
    }
}