package com.fastestindia.thedatatalk.CollabActivities

import com.google.gson.annotations.SerializedName

class GetCollabReplies(
    @field:SerializedName("model") var model: String, @field:SerializedName(
        "pk"
    ) var pk: String, @field:SerializedName("fields") var fields: CollabReplyData
)