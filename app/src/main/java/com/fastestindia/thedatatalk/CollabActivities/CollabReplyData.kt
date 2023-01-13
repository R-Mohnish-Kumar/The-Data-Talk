package com.fastestindia.thedatatalk.CollabActivities

import com.google.gson.annotations.SerializedName

class CollabReplyData {
    @field:SerializedName("Response")
    var response: String?=null
    @field:SerializedName("collab_id")
    var collab_id: String?=null
    @field:SerializedName("start_date")
    var start_date: String?=null
    @field:SerializedName("uploaded_by")
    var uploaded_by: String?=null

    constructor(collab_id: String, requested_on: String, uploaded_by: String) {
        this.collab_id = collab_id
        this.start_date = requested_on
        this.uploaded_by = uploaded_by
    }

    constructor(response: String) {
        this.response = response
    }
}