package com.fastestindia.thedatatalk.QueryActivities

import com.google.gson.annotations.SerializedName

class GetQueryDetails {
    @SerializedName("model")
    var model: String? = null

    @SerializedName("pk")
    var pk: String? = null

    @JvmField
    @SerializedName("fields")
    var fields: QueryData? = null
}