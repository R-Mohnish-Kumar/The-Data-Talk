package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment8 : Fragment() {
    lateinit var word: CardView
    lateinit var ruby: CardView
    lateinit var cyberSecurity: CardView
    lateinit var itOperations: CardView
    lateinit var rust: CardView
    lateinit var mongoDB: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_section8, container, false)
        word = view.findViewById(R.id.wordCardView)
        ruby = view.findViewById(R.id.rubyCardView)
        cyberSecurity = view.findViewById(R.id.cyberSecurityCardView)
        itOperations = view.findViewById(R.id.itOperationsCardView)
        mongoDB = view.findViewById(R.id.mongoDBCardView)
        rust = view.findViewById(R.id.rustCardView)
        word.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Microsoft Word")
            startActivity(intent)
        })
        ruby.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Ruby on Rails ????")
            startActivity(intent)
        })
        cyberSecurity.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Cybersecurity")
            startActivity(intent)
        })
        itOperations.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "IT Operations")
            startActivity(intent)
        })
        rust.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Rust")
            startActivity(intent)
        })
        mongoDB.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "MongoDB")
            startActivity(intent)
        })
        return view
    }
}