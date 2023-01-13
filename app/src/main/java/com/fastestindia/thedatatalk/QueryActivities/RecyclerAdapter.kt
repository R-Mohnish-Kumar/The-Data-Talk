package com.fastestindia.thedatatalk.QueryActivities

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.fastestindia.thedatatalk.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import android.widget.LinearLayout

class RecyclerAdapter(var context: Context, var queryDetails: List<GetQueryDetails>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getQueryDetails = queryDetails[position]
        holder.title.text = getQueryDetails.fields!!.title
        holder.cardView.setOnClickListener {
            val intent = Intent(context, PopWindowActivity::class.java)
            val bundle = Bundle()
            bundle.putString("title", getQueryDetails.fields!!.title)
            bundle.putString("keywords", getQueryDetails.fields!!.keywords)
            bundle.putString("start_date", getQueryDetails.fields!!.start_date)
            bundle.putString("uploaded_by", getQueryDetails.fields!!.uploaded_by)
            bundle.putString("pk", getQueryDetails.pk)
            intent.putExtras(bundle)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        holder.dateTv.text = getQueryDetails.fields!!.start_date.substring(0, 10)
    }

    override fun getItemCount(): Int {
        return queryDetails.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var dateTv: TextView
        var cardView: CardView
        var linearLayout: LinearLayout

        init {
            title = itemView.findViewById(R.id.question)
            linearLayout = itemView.findViewById(R.id.LinearLayoutQuery)
            cardView = itemView.findViewById(R.id.cardViewLayout)
            dateTv = itemView.findViewById(R.id.uploader)
        }
    }
}