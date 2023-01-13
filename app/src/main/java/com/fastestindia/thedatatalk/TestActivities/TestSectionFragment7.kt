package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment7 : Fragment() {
    lateinit var noSql: CardView
    lateinit var powerBI: CardView
    lateinit var oop: CardView
    lateinit var css: CardView
    lateinit var ads: CardView
    lateinit var html: CardView
    lateinit var gcp: CardView
    lateinit var scala: CardView
    lateinit var swift: CardView
    lateinit var vba: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_section7, container, false)
        noSql = view.findViewById(R.id.noSQLCardView)
        powerBI = view.findViewById(R.id.powerBICardView)
        oop = view.findViewById(R.id.oopsCardView)
        css = view.findViewById(R.id.cssCardView)
        ads = view.findViewById(R.id.googleAdsCardView)
        html = view.findViewById(R.id.htmlCardView)
        gcp = view.findViewById(R.id.googleCloudPlatformCardView)
        scala = view.findViewById(R.id.scalaCardView)
        swift = view.findViewById(R.id.swiftCardView)
        vba = view.findViewById(R.id.visualBasicsCardView)
        noSql.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "NoSQL")
            startActivity(intent)
        })
        powerBI.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Power BI")
            startActivity(intent)
        })
        oop.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "OOP")
            startActivity(intent)
        })
        css.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "CSS")
            startActivity(intent)
        })
        ads.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Google Ads")
            startActivity(intent)
        })
        html.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "HTML")
            startActivity(intent)
        })
        gcp.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Google Cloud Platform (GCP)")
            startActivity(intent)
        })
        scala.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Scala")
            startActivity(intent)
        })
        swift.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Swift")
            startActivity(intent)
        })
        vba.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Visual Basic for Applications (VBA)")
            startActivity(intent)
        })
        return view
    }
}