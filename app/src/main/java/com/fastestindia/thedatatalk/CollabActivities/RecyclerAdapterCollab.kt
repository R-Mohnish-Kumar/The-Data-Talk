package com.fastestindia.thedatatalk.CollabActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R

class RecyclerAdapterCollab(var context: Context, var collabDetails: List<CollabDataItem>) :
    RecyclerView.Adapter<RecyclerAdapterCollab.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item_collab, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getCollabDetails = collabDetails[position]
        holder.title.text = getCollabDetails.fields!!.title
        holder.cardView.setOnClickListener {
            val intent = Intent(context, CollabPopWindowActivity::class.java)
            val bundle = Bundle()
            bundle.putString("title", getCollabDetails.fields!!.title)
            bundle.putString("partNo", getCollabDetails.fields!!.partNo)
            bundle.putString("assignedto", getCollabDetails.fields!!.assignedto)
            bundle.putString("requested_on", getCollabDetails.fields!!.requested_on)
            bundle.putString("uploaded_by", getCollabDetails.fields!!.uploaded_by)
            bundle.putString("desc", getCollabDetails.fields!!.desc)
            bundle.putString("pk", getCollabDetails!!.pk)
            intent.putExtras(bundle)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        holder.dateTv.text = getCollabDetails.fields!!.requested_on.substring(0, 10)
    }

    override fun getItemCount(): Int {
        return collabDetails.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var dateTv: TextView
        var cardView: CardView
        var linearLayout: LinearLayout
        var uploader: TextView

        init {
            title = itemView.findViewById(R.id.titleCollab)
            linearLayout = itemView.findViewById(R.id.LinearLayoutCollab)
            cardView = itemView.findViewById(R.id.cardViewLayoutCollab)
            dateTv = itemView.findViewById(R.id.dateCollab)
            uploader=itemView.findViewById(R.id.uploaderCollab)
        }
    }
}