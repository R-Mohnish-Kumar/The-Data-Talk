package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment2 : Fragment() {
   lateinit var mySql: CardView
    lateinit var eclipse: CardView
    lateinit var jquery: CardView
    lateinit var acrobat: CardView
    lateinit var unity: CardView
    lateinit var bash: CardView
    lateinit var photoshop: CardView
    lateinit var kotlin: CardView
    lateinit var python: CardView
    lateinit var ppt: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_test_section2, container, false)
        mySql = view.findViewById(R.id.mySQLCardView)
        eclipse = view.findViewById(R.id.eclipseCardView)
        jquery = view.findViewById(R.id.jQueryCardView)
        acrobat = view.findViewById(R.id.acrobatCardView)
        unity = view.findViewById(R.id.unityCardView)
        bash = view.findViewById(R.id.bashCardView)
        photoshop = view.findViewById(R.id.photoshopCardView)
        kotlin = view.findViewById(R.id.kotlinCardView)
        python = view.findViewById(R.id.pythonCardView)
        ppt = view.findViewById(R.id.pptCardView)
        mySql.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "MySQL")
            startActivity(intent)
        })
        eclipse.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Eclipse")
            startActivity(intent)
        })
        jquery.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "jQuery ????")
            startActivity(intent)
        })
        acrobat.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Adobe-Acrobat")
            startActivity(intent)
        })
        unity.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Unity")
            startActivity(intent)
        })
        bash.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Bash")
            startActivity(intent)
        })
        photoshop.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Adobe-Photoshop")
            startActivity(intent)
        })
        kotlin.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Kotlin")
            startActivity(intent)
        })
        python.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Python")
            startActivity(intent)
        })
        ppt.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Power Point")
            startActivity(intent)
        })
        return view
    }
}