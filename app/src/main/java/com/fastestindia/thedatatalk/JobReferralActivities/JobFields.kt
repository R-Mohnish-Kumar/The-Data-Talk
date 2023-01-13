package com.fastestindia.thedatatalk.JobReferralActivities

import com.google.gson.annotations.SerializedName

data class JobFields(
    @field:SerializedName("assignedto") val assignedto: String,
    @field:SerializedName("expert") val expert: String,
    @field:SerializedName("query") val query: String,
    @field:SerializedName("requested_on") val requested_on: String,
    @field:SerializedName("uploaded_by") val uploaded_by: String,
    @field:SerializedName("urgency") val urgency: String
)
