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

class CourseCertificationRecyclerAdapter(var context: Context, var linkArrayList: ArrayList<String>, var certificationName: ArrayList<String>) :
    RecyclerView.Adapter<CourseCertificationRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.certification_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getLink= linkArrayList[position]
        val certicationName=certificationName[position]
            holder.certificationTitle.text=certicationName
            holder.certificationTopic.text="Certification"
            holder.certificationTitle.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data= Uri.parse(getLink)
                openURL.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                ContextCompat.startActivity(context, openURL, null)
            }
    }

    override fun getItemCount(): Int {
        return linkArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var certificationTopic: TextView
        var certificationTitle: TextView
        var certificationCardView: NeumorphCardView

        init {
            certificationTitle= itemView.findViewById(R.id.certificationTextView)
            certificationTopic = itemView.findViewById(R.id.certificationTopicTextView)
            certificationCardView = itemView.findViewById(R.id.certificationDataCardView)
        }
    }
}