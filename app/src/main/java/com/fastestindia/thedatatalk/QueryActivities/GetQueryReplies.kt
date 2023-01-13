package com.fastestindia.thedatatalk.QueryActivities

import com.google.gson.annotations.SerializedName

class GetQueryReplies(
    @field:SerializedName("model") var model: String, @field:SerializedName(
        "pk"
    ) var pk: String, @field:SerializedName("fields") var fields: QueryReplyData
)