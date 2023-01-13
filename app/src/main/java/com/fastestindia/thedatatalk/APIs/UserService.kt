package com.fastestindia.thedatatalk.APIs

import androidx.annotation.NonNull
import com.fastestindia.thedatatalk.ForgotPasswordDetails
import com.fastestindia.thedatatalk.ProfileActivities.ProfileUpdate
import com.fastestindia.thedatatalk.ProfileActivities.UpdateResponse
import com.fastestindia.thedatatalk.QueryActivities.GetQueryDetails
import com.fastestindia.thedatatalk.SharedPrefaManager
import com.fastestindia.thedatatalk.UpdateForgotPassword
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @FormUrlEncoded
    @POST("v/register/")
    fun registerUser(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("contact") contact: String,
        @Field("name") name: String,
        @Field("coupon") couponcode: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("v/login/")
    fun loginUser(
        @Field("username") login_username: String,
        @Field("password") login_password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("v/forgot-password/")
    fun forgotPassword(
        @Field("username") username: String
    ): Call<ForgotPasswordDetails>

    @FormUrlEncoded
    @POST("v/forgot-password/")
    fun updateForgotPassword(
        @Field("username") username: String,
        @Field("otp") otp: String,
        @Field("password") password: String
    ): Call<UpdateForgotPassword>

    @FormUrlEncoded
    @POST("/v/update_profile/")
    fun updateProfile(
        @Header("Authorization") authorizationKey: String,
        @Field("designation") designation: String,
        @Field("company") company: String,
        @Field("experience") experience: String,
        @Field("college") college: String,
        @Field("stream") stream: String,
        @Field("profile_brief") profile_brief: String,
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String
    ): Call<ProfileUpdate>


    @GET("v/login/")
    fun refreshDetails(@Header("Authorization") authorizationKey: String) : Call<RefreshLoginResponse>

    @Multipart
    @POST("v/update_photo/")
    fun uploadProfileImage(
        @HeaderMap token: Map<String,String>,
        @Part files: MultipartBody.Part,
        @Part("desc") desc: RequestBody
    ): Call<UpdateResponse>

    @FormUrlEncoded
    @POST("v/payment_redirect_login/")
    fun paymentUpdate(
        @Header("Authorization") authorizationKey: String,
        @Field("amount") amount: String
    ):Call<String>

    @FormUrlEncoded
    @POST("/v/update_password/")
    fun updatePassword(
        @Header("Authorization") authorizationKey: String,
        @Field("password") password: String
    ):Call<String>
}