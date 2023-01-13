package com.fastestindia.thedatatalk.JobReferralActivities

import com.google.gson.annotations.SerializedName


class JobDataItem {
    @SerializedName("model")
    var model: String? = null

    @SerializedName("pk")
    var pk: String? = null

    @JvmField
    @SerializedName("fields")
    var fields: JobFields? = null
}