package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment4 : Fragment() {
    lateinit var server: CardView
    lateinit var git: CardView
    lateinit var r: CardView
    lateinit var analytics: CardView
    lateinit var project: CardView
    lateinit var api: CardView
    lateinit var react: CardView
    lateinit var visio: CardView
    lateinit var xml: CardView
    lateinit var json: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_section4, container, false)
        server = view.findViewById(R.id.windowsServerCardView)
        git = view.findViewById(R.id.gitCardView)
        r = view.findViewById(R.id.rProgrammingCardView)
        analytics = view.findViewById(R.id.analyticsCardView)
        project = view.findViewById(R.id.projectCardView)
        api = view.findViewById(R.id.restApiCardView)
        react = view.findViewById(R.id.reactCardView)
        visio = view.findViewById(R.id.visioCardView)
        xml = view.findViewById(R.id.xmlCardView)
        json = view.findViewById(R.id.jsonCardView)
        server.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Windows Server")
            startActivity(intent)
        })
        git.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Git ⭐")
            startActivity(intent)
        })
        r.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "R")
            startActivity(intent)
        })
        analytics.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Google Analytics")
            startActivity(intent)
        })
        project.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Project")
            startActivity(intent)
        })
        api.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "REST API ????")
            startActivity(intent)
        })
        react.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "React.js ????")
            startActivity(intent)
        })
        visio.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Visio")
            startActivity(intent)
        })
        xml.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "XML")
            startActivity(intent)
        })
        json.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "JSON")
            startActivity(intent)
        })
        return view
    }
}