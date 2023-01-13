package com.fastestindia.thedatatalk.QueryActivities

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.fastestindia.thedatatalk.R
import android.widget.TextView

class ReplyRecyclerAdapter(var context: Context, var queryReplies: List<GetQueryReplies>) :
    RecyclerView.Adapter<ReplyRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reply_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val getQueryReplies = queryReplies[position]
        holder.responseComment.text = getQueryReplies.fields.response.toString()
        val queryId= getQueryReplies.fields.query_id.toString()
        Log.e("Query",queryId)
    }

    override fun getItemCount(): Int {
        return queryReplies.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var responseComment: TextView

        init {
            responseComment = itemView.findViewById(R.id.responseTextView)
        }
    }
}