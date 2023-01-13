package com.fastestindia.thedatatalk.ResourceActivities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.fastestindia.thedatatalk.R
import soup.neumorphism.NeumorphCardView

class ModelRecyclerAdapter (var context: Context,var namesArray: ArrayList<String>,var notebookLinkArray :ArrayList<String>) :
    RecyclerView.Adapter<ModelRecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.models_row_item, parent, false)
        return ModelRecyclerAdapter.ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var modelTextView: TextView
        var nameTextView: TextView
        var modelDataCardView: NeumorphCardView
        init {
            modelTextView=itemView.findViewById(R.id.modelTextView)
            nameTextView=itemView.findViewById(R.id.nameTextView)
            modelDataCardView=itemView.findViewById(R.id.modelsDataCardView)
        }
    }

    override fun onBindViewHolder(holder: ModelRecyclerAdapter.ViewHolder, position: Int) {
        val getName=namesArray[position]
        val getLink=notebookLinkArray[position]
        holder.nameTextView.text = getName
        holder.modelDataCardView.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data= Uri.parse(getLink)
            openURL.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(context,openURL,null)

        }
    }

    override fun getItemCount(): Int {
        return namesArray.size
    }

}