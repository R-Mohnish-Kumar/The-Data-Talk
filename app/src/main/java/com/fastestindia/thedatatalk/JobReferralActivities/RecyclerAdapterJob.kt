package com.fastestindia.thedatatalk.JobReferralActivities

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

class RecyclerAdapterJob(var context: Context, var jobDetails: List<JobDataItem>) :
    RecyclerView.Adapter<RecyclerAdapterJob.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item_job, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getJobDetails = jobDetails[position]
        holder.title.text = getJobDetails.fields!!.query
        holder.cardView.setOnClickListener {
            val intent = Intent(context, JobPopWindowActivity::class.java)
            val bundle = Bundle()
            bundle.putString("title", getJobDetails.fields!!.query)
            bundle.putString("urgency", getJobDetails.fields!!.urgency)
            bundle.putString("assignedto", getJobDetails.fields!!.assignedto)
            bundle.putString("requested_on", getJobDetails.fields!!.requested_on)
            bundle.putString("uploaded_by", getJobDetails.fields!!.uploaded_by)
            bundle.putString("desc", getJobDetails.fields!!.expert)
            bundle.putString("pk", getJobDetails!!.pk)
            intent.putExtras(bundle)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        holder.dateTv.text = getJobDetails.fields!!.requested_on.substring(0, 10)
    }

    override fun getItemCount(): Int {
        return jobDetails.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var dateTv: TextView
        var cardView: CardView
        var linearLayout: LinearLayout
        var uploader: TextView

        init {
            title = itemView.findViewById(R.id.titleJob)
            linearLayout = itemView.findViewById(R.id.LinearLayoutJob)
            cardView = itemView.findViewById(R.id.cardViewLayoutJob)
            dateTv = itemView.findViewById(R.id.dateJob)
            uploader=itemView.findViewById(R.id.uploaderJob)
        }
    }
}