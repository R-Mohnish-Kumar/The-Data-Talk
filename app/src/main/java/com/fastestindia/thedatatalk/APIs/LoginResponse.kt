package com.fastestindia.thedatatalk.APIs

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @field:SerializedName("user")
    var user: User
    @field:SerializedName("status")
    var status: String
    @field:SerializedName("Authorization")
    var authorization: String

    constructor(user: User, status: String, authorization: String) {
        this.user = user
        this.status = status
        this.authorization = authorization
    }

}