package com.fastestindia.thedatatalk.EventsActivities

import com.google.gson.annotations.SerializedName

class EventData(@field:SerializedName("EventName") var EventName: String,
                @field:SerializedName("Date") var date: String,
                @field:SerializedName("StartTime") var StartTime: String,
                @field:SerializedName("EndTime") var EndTime: String,
                @field:SerializedName("UploadDate") var UploadDate: String,
                @field:SerializedName("MeetLink") var MeetLink: String,
                @field:SerializedName("MeetId") var MeetId: String,
                @field:SerializedName("MeetPassword") var MeetPassword: String)