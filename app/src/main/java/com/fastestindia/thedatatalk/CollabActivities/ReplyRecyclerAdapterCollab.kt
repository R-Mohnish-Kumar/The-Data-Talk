package com.fastestindia.thedatatalk.CollabActivities

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.fastestindia.thedatatalk.R

class ReplyRecyclerAdapterCollab(var context: Context, var collabReplies: List<GetCollabReplies>) :
    RecyclerView.Adapter<ReplyRecyclerAdapterCollab.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reply_row_item_collab, parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ReplyRecyclerAdapterCollab.ViewHolder, position: Int) {
        val getQueryReplies = collabReplies[position]
        holder.responseComment.text = getQueryReplies.fields.response.toString()
    }
    override fun getItemCount(): Int {
        return collabReplies.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var responseComment: TextView

        init {
            responseComment = itemView.findViewById(R.id.responseTextView)
        }
    }


}
