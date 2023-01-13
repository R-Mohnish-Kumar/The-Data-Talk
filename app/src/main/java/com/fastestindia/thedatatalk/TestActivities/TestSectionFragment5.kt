package com.fastestindia.thedatatalk.TestActivities

import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment

public class TestSectionFragment5 : Fragment() {
    lateinit var accounting: CardView
    lateinit var sharepoints: CardView
    lateinit var quickbooks: CardView
    lateinit var solidworks: CardView
    lateinit var tSQL: CardView
    lateinit var cpp: CardView
    lateinit var autodesk: CardView
    lateinit var aws: CardView
    lateinit var linux: CardView
    lateinit var matlab: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_section5, container, false)
        accounting = view.findViewById(R.id.accountingCardView)
        sharepoints = view.findViewById(R.id.sharePointsCardView)
        quickbooks = view.findViewById(R.id.quickBooksCardView)
        solidworks = view.findViewById(R.id.solidworksCardView)
        tSQL = view.findViewById(R.id.transactSQLCardView)
        cpp = view.findViewById(R.id.cppCardView)
        autodesk = view.findViewById(R.id.fusion360CardView)
        aws = view.findViewById(R.id.awsCardView)
        linux = view.findViewById(R.id.linuxCardView)
        matlab = view.findViewById(R.id.matlabCardView)
        sharepoints.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "SharePoint")
            startActivity(intent)
        })
        quickbooks.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "QuickBooks")
            startActivity(intent)
        })
        solidworks.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "SOLIDWORKS")
            startActivity(intent)
        })
        tSQL.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Transact-SQL (T-SQL)")
            startActivity(intent)
        })
        cpp.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "C++")
            startActivity(intent)
        })
        autodesk.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Autodesk Fusion 360")
            startActivity(intent)
        })
        aws.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "AWS")
            startActivity(intent)
        })
        linux.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Linux")
            startActivity(intent)
        })
        matlab.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "MATLAB")
            startActivity(intent)
        })
        accounting.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TestSessionActivity::class.java)
            intent.putExtra("course", "Accounting")
            startActivity(intent)
        })
        return view
    }
}