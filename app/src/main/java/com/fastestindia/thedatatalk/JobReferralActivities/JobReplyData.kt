package com.fastestindia.thedatatalk.JobReferralActivities

import com.google.gson.annotations.SerializedName

class JobReplyData {
    @field:SerializedName("Response")
    var response: String?=null
    @field:SerializedName("expert_id")
    var expert_id: String?=null
    @field:SerializedName("start_date")
    var start_date: String?=null
    @field:SerializedName("uploaded_by")
    var uploaded_by: String?=null

    constructor(job_id: String, requested_on: String, uploaded_by: String) {
        this.expert_id = job_id
        this.start_date = requested_on
        this.uploaded_by = uploaded_by
    }

    constructor(response: String) {
        this.response = response
    }
}