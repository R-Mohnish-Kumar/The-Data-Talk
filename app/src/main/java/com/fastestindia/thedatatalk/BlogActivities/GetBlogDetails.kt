package com.fastestindia.thedatatalk.BlogActivities

import com.google.gson.annotations.SerializedName

class GetBlogDetails {
    @SerializedName("model")
    var model: String?=null
    @SerializedName("pk")
    var pk: String?=null
    @SerializedName("fields")
    var fields:BlogData?=null
}