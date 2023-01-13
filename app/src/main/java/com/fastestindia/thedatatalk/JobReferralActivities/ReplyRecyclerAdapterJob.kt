package com.fastestindia.thedatatalk.JobReferralActivities

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.fastestindia.thedatatalk.R
import android.widget.TextView

class ReplyRecyclerAdapterJob(var context: Context, var jobReplies: List<GetJobReplies>) :
    RecyclerView.Adapter<ReplyRecyclerAdapterJob.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reply_row_item_job, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return jobReplies.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var responseComment: TextView

        init {
            responseComment = itemView.findViewById(R.id.responseTextView)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getJobReplies = jobReplies[position]
        holder.responseComment.text = getJobReplies.fields.response.toString()
    }
}