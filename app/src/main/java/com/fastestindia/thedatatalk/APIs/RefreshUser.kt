package com.fastestindia.thedatatalk.APIs

import com.google.gson.annotations.SerializedName

class RefreshUser(
    @SerializedName("username")
    var username: String?,
    @SerializedName("firstname")
    var firstname: String?,
    @SerializedName("lastname")
    var lastname: String?,
    @SerializedName("contact")
    var contact: String?,
    @SerializedName("designation")
    var designation: String?,
    @SerializedName("company")
    var company: String?,
    @SerializedName("experience")
    var experience: String?,
    @SerializedName("college")
    var college: String?,
    @SerializedName("stream")
    var stream: String?,
    @SerializedName("start_date")
    var start_date: String?,
    @SerializedName("end_date")
    var end_date: String?,
    @SerializedName("profile_brief")
    var profile_brief: String?,
    @SerializedName("workshop")
    var workshop: String?,
    @SerializedName("su")
    var su: String?,
    @SerializedName("invite_code")
    var invite_code: String?,
    @SerializedName("ic_usage")
    var ic_usage: String?
)