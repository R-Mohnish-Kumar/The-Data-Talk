package com.fastestindia.thedatatalk.QueryActivities

import com.google.gson.annotations.SerializedName

class QueryData(
    @field:SerializedName("title") var title: String,
    @field:SerializedName("start_date") var start_date: String,
    @field:SerializedName("keywords") var keywords: String,
    @field:SerializedName("uploaded_by") var uploaded_by: String
)