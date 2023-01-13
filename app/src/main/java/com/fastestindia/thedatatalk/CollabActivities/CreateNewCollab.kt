package com.fastestindia.thedatatalk.CollabActivities

import com.google.gson.annotations.SerializedName

class CreateNewCollab(
    @field:SerializedName("partno")
    var noOfParticipants: String,
    @field:SerializedName("title")
    var title: String,
    @field:SerializedName("desc")
    var description: String)