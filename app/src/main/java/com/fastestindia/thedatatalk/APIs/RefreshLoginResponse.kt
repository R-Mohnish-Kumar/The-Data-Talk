package com.fastestindia.thedatatalk.APIs

import com.google.gson.annotations.SerializedName

class RefreshLoginResponse {
    @field:SerializedName("user")
    var user: RefreshUser
    @field:SerializedName("status")
    var status: String
    @field:SerializedName("Authorization")
    var authorization: String

    constructor(user: RefreshUser, status: String, authorization: String) {
        this.user = user
        this.status = status
        this.authorization = authorization
    }

}