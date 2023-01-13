package com.fastestindia.thedatatalk.BlogActivities

import com.google.gson.annotations.SerializedName

class CreateNewBlog (
                     @field:SerializedName("title")
                     var title: String,
                     @field:SerializedName("editordata")
                     var editordata: String)