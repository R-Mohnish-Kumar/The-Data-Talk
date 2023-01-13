package com.fastestindia.thedatatalk

import com.google.gson.annotations.SerializedName

class UpdateForgotPassword (@field:SerializedName("username")var username:String,
                            @field:SerializedName("otp")
                            var otp:String,
                            @field:SerializedName("password")
                            var password:String)