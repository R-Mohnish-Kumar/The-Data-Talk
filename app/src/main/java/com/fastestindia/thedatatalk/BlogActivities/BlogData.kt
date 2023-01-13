package com.fastestindia.thedatatalk.BlogActivities

import com.google.gson.annotations.SerializedName

class BlogData(@field:SerializedName("title")
               var title:String,
               @field:SerializedName("description")
               var description:String,
               @field:SerializedName("start_date")
               var start_date:String,
               @field:SerializedName("uploaded_by")
               var uploaded_by:String,
               @field:SerializedName("verified_by")
               var verified_by:String)
