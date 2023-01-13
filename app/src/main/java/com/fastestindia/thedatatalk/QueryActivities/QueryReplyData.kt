package com.fastestindia.thedatatalk.QueryActivities

import com.google.gson.annotations.SerializedName

class QueryReplyData {
    @field:SerializedName("Response")
    var response: String?=null
    @field:SerializedName("Query_id")
    var query_id: String?=null
    @field:SerializedName("start_date")
    var start_date: String?=null
    @field:SerializedName("upvote")
    var upvote: String?=null
    @field:SerializedName("uploaded_by")
    var uploaded_by: String?=null

    constructor(query_id: String, start_date: String, upvote: String, uploaded_by: String) {
        this.query_id = query_id
        this.start_date = start_date
        this.upvote = upvote
        this.uploaded_by = uploaded_by
    }

    constructor(response: String) {
        this.response = response
    }
}