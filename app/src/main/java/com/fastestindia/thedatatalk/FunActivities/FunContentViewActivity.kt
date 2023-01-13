package com.fastestindia.thedatatalk.FunActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R
import org.json.JSONArray
import java.nio.charset.Charset

class FunContentViewActivity : AppCompatActivity() {
    lateinit var funTitle:TextView
    var nameArrayList:ArrayList<String> = ArrayList()
    var linkArrayList:ArrayList<String> = ArrayList()
    lateinit var funContentRecyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_content)
        funTitle=findViewById(R.id.funTitle)
        funContentRecyclerView=findViewById(R.id.funContentRecyclerView)
        funContentRecyclerView.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(this)
        funContentRecyclerView.layoutManager=linearLayoutManager

        val funtitle=intent.getStringExtra("Type")
        funTitle.text=funtitle


        val json: String
        val inputStream = assets.open("fun.json")
        val size = inputStream.available()
        val bytes = ByteArray(size)
        inputStream.read(bytes)
        inputStream.close()
        val charset: Charset =Charset.forName("UTF-8")
        json = String(bytes, charset)
        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.getString("Type") == funtitle) {
                nameArrayList.add(jsonObject.getString("Name"))
                linkArrayList.add(jsonObject.getString("Link"))
            }
        }

        Log.e("Name",nameArrayList.toString())
        Log.e("Link",linkArrayList.toString())
        funContentRecyclerView.adapter=FunRecyclerAdapter(applicationContext,
            nameArrayList, linkArrayList
        )
    }
}