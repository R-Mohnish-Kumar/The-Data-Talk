package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment3 : Fragment() {
    lateinit var frontEnd: CardView
    lateinit var java: CardView
    lateinit var objC: CardView
    lateinit var outlook: CardView
    lateinit var access: CardView
    lateinit var excel: CardView
    lateinit var hadoop: CardView
    lateinit var go: CardView
    lateinit var android: CardView
    lateinit var seo: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_test_section3, container, false)
        frontEnd = view.findViewById(R.id.frontEndCardView)
        java = view.findViewById(R.id.javaCardView)
        objC = view.findViewById(R.id.objectiveCCardView)
        access = view.findViewById(R.id.accessCardView)
        excel = view.findViewById(R.id.excelCardView)
        hadoop = view.findViewById(R.id.hadoopCardView)
        go = view.findViewById(R.id.goCardView)
        android = view.findViewById(R.id.androidCardView)
        seo = view.findViewById(R.id.seoCardView)
        outlook = view.findViewById(R.id.outlookCardView)

        frontEnd.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Front-end Development")
            startActivity(intent)
        })
        java.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Java")
            startActivity(intent)
        })
        objC.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "objective-c")
            startActivity(intent)
        })
        access.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Access")
            startActivity(intent)
        })
        excel.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Excel")
            startActivity(intent)
        })
        hadoop.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Hadoop")
            startActivity(intent)
        })
        go.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Go (Programming Language")
            startActivity(intent)
        })
        android.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Android")
            startActivity(intent)
        })
        seo.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Search Engine Optimization (SEO)")
            startActivity(intent)
        })
        outlook.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Outlook")
            startActivity(intent)
        })
        return view
    }
}