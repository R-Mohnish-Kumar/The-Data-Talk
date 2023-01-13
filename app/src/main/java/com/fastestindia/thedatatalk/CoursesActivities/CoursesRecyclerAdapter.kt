package com.fastestindia.thedatatalk.CoursesActivities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R
import soup.neumorphism.NeumorphCardView

class CoursesRecyclerAdapter(var context: Context, var topicsArrayList: ArrayList<String>,var linkArrayList: ArrayList<String>,var paidNameArrayList: ArrayList<String>,var freeNameArrayList: ArrayList<String>) :
    RecyclerView.Adapter<CoursesRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.courses_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getTopicName = topicsArrayList[position]
        val getLink= linkArrayList[position]
        holder.courseTitle.text="Lecture"
        holder.courseTopic.text=getTopicName
        holder.courseCardView.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data= Uri.parse(getLink)
            openURL.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ContextCompat.startActivity(context, openURL, null)
        }
    }

    override fun getItemCount(): Int {
        return topicsArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var courseTopic:TextView
        var courseTitle:TextView
        var courseCardView:NeumorphCardView

        init {
            courseTitle= itemView.findViewById(R.id.coursesTextView)
            courseTopic = itemView.findViewById(R.id.courseTopicTextView)
            courseCardView = itemView.findViewById(R.id.courseDataCardView)
        }
    }
}