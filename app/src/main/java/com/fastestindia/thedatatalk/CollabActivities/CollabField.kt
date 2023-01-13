package com.fastestindia.thedatatalk.CollabActivities
import com.google.gson.annotations.SerializedName

data class CollabField(
    @field:SerializedName("Title") var title: String,
    @field:SerializedName("assignedto") var assignedto: String,
    @field:SerializedName("desc") var desc: String,
    @field:SerializedName("partNo") var partNo: String,
    @field:SerializedName("requested_on") var requested_on: String,
    @field:SerializedName("uploaded_by") var uploaded_by: String
)