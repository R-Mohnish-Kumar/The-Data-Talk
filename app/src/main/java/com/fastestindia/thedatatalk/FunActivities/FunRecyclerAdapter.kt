package com.fastestindia.thedatatalk.FunActivities

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

class FunRecyclerAdapter(var context: Context, var nameArrayList: ArrayList<String>, var linkArrayList: ArrayList<String>) :
    RecyclerView.Adapter<FunRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fun_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getLink= linkArrayList[position]
        val getTitle =nameArrayList[position]
        holder.funTitle.text=getTitle
        holder.funCardView.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data= Uri.parse(getLink)
            openURL.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ContextCompat.startActivity(context, openURL, null)
        }
    }

    override fun getItemCount(): Int {
        return nameArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var funTitle: TextView
        var funCardView: NeumorphCardView

        init {
            funTitle= itemView.findViewById(R.id.FunTopicTextView)
            funCardView = itemView.findViewById(R.id.funDataCardView)
        }
    }
}