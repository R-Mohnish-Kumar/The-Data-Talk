package com.fastestindia.thedatatalk.CollabActivities
import com.google.gson.annotations.SerializedName

class CollabDataItem {
    @SerializedName("model")
    var model: String? = null

    @SerializedName("pk")
    var pk: String? = null

    @JvmField
    @SerializedName("fields")
    var fields: CollabField? = null
}