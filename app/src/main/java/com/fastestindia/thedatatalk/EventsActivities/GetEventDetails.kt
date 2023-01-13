package com.fastestindia.thedatatalk.EventsActivities

import com.google.gson.annotations.SerializedName

class GetEventDetails {
    @SerializedName("model")
    var model: String? = null

    @SerializedName("pk")
    var pk: String? = null

    @JvmField
    @SerializedName("fields")
    var fields: EventData? = null
}