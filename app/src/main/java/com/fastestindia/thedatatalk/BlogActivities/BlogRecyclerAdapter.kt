package com.fastestindia.thedatatalk.BlogActivities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R

class BlogRecyclerAdapter(var context: Context, var blogDetails: List<GetBlogDetails>) :
    RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.blog_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getBlogDetails = blogDetails[position]
        holder.title.text = getBlogDetails.fields!!.title
        holder.cardView.setOnClickListener {
            val intent = Intent(context, BlogDataContentActivity::class.java)
            intent.putExtra("title",getBlogDetails.fields!!.title)
            intent.putExtra("description",getBlogDetails.fields!!.description)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        holder.dateTv.text = getBlogDetails.fields!!.start_date.substring(0, 10)
    }

    override fun getItemCount(): Int {
        return blogDetails.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var dateTv: TextView
        var cardView: CardView
        var linearLayout: LinearLayout

        init {
            title = itemView.findViewById(R.id.blogTitleTv)
            linearLayout = itemView.findViewById(R.id.LinearLayoutBlog)
            cardView = itemView.findViewById(R.id.blogCardViewLayout)
            dateTv = itemView.findViewById(R.id.blogDateTv)
        }
    }


}