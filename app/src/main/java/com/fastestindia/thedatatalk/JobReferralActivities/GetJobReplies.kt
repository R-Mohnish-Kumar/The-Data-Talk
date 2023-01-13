package com.fastestindia.thedatatalk.JobReferralActivities

import com.google.gson.annotations.SerializedName

class GetJobReplies(
    @field:SerializedName("model") var model: String, @field:SerializedName(
        "pk"
    ) var pk: String, @field:SerializedName("fields") var fields: JobReplyData
)