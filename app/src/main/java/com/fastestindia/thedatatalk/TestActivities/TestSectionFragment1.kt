package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment1 : Fragment() {
    lateinit var ml: CardView
    lateinit var adobe: CardView
    lateinit var javascript: CardView
    lateinit var cProgramming: CardView
    lateinit var node: CardView
    lateinit var spring: CardView
    lateinit var agile: CardView
    lateinit var dotNet: CardView
    lateinit var maven: CardView
    lateinit var azure: CardView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View {
        val view=inflater.inflate(R.layout.fragment_test_section1, container, false)
        ml = view.findViewById(R.id.machineLearningCardView)
        adobe = view.findViewById(R.id.adobeCardView)
        javascript = view.findViewById(R.id.javaScriptCardView)
        cProgramming = view.findViewById(R.id.cProgrammingCardView)
        node = view.findViewById(R.id.nodeJsCardView)
        spring = view.findViewById(R.id.springCardView)
        agile = view.findViewById(R.id.agileCardView)
        dotNet = view.findViewById(R.id.dotNetCardView)
        maven = view.findViewById(R.id.mavenCardView)
        azure = view.findViewById(R.id.azureCardView)
        ml.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Machine Learning")
            startActivity(intent)
        })
        adobe.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Adobe-Illustrator")
            startActivity(intent)
        })
        javascript.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Javascript")
            startActivity(intent)
        })
        cProgramming.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "C (Programming Language)")
            startActivity(intent)
        })
        node.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "node.js")
            startActivity(intent)
        })
        spring.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Spring Framework")
            startActivity(intent)
        })
        agile.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Agile Methodologies")
            startActivity(intent)
        })
        dotNet.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", ".NET Framework")
            startActivity(intent)
        })
        maven.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Maven ????")
            startActivity(intent)
        })
        azure.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Azure")
            startActivity(intent)
        })
        return view
    }
}