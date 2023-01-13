package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment6 : Fragment() {
    lateinit var lambda: CardView
    lateinit var wordpress: CardView
    lateinit var autoCAD: CardView
    lateinit var django: CardView
    lateinit var premierePro: CardView
    lateinit var inDesign: CardView
    lateinit var lightroom: CardView
    lateinit var cSharp: CardView
    lateinit var php: CardView
    lateinit var angular: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_section6, container, false)
        lambda = view.findViewById(R.id.awsLambdaCardView)
        wordpress = view.findViewById(R.id.wordPressCardView)
        autoCAD = view.findViewById(R.id.autoCADCardView)
        django = view.findViewById(R.id.djangoCardView)
        premierePro = view.findViewById(R.id.premiereProCardView)
        inDesign = view.findViewById(R.id.inDesignCardView)
        lightroom = view.findViewById(R.id.lightroomCardView)
        cSharp = view.findViewById(R.id.cSharpCardView)
        php = view.findViewById(R.id.phpCardView)
        angular = view.findViewById(R.id.angularCardView)
        lambda.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "AWS-Lambda ????")
            startActivity(intent)
        })
        wordpress.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "WordPress")
            startActivity(intent)
        })
        autoCAD.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "AutoCAD")
            startActivity(intent)
        })
        django.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Django")
            startActivity(intent)
        })
        premierePro.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Adobe Premiere Pro")
            startActivity(intent)
        })
        inDesign.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Adobe-InDesign")
            startActivity(intent)
        })
        lightroom.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Adobe-Lightroom")
            startActivity(intent)
        })
        cSharp.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "C#")
            startActivity(intent)
        })
        php.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "PHP")
            startActivity(intent)
        })
        angular.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Angular")
            startActivity(intent)
        })
        return view
    }
}