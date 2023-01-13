package com.fastestindia.thedatatalk.APIs

import com.fastestindia.thedatatalk.JobReferralActivities.CreateNewJob
import com.fastestindia.thedatatalk.JobReferralActivities.GetJobReplies
import com.fastestindia.thedatatalk.JobReferralActivities.JobDataItem
import com.fastestindia.thedatatalk.JobReferralActivities.PostJobReply
import retrofit2.Call
import retrofit2.http.*

interface JobAPI {
    @get:GET("v/expert_request/")
    val JobDetails: Call<List<JobDataItem>>

    @FormUrlEncoded
    @POST("v/collect_expert_reply/ ")
    fun getJobReply(
        @Header("Authorization") authorizationToken: String,
        @Field("pk") pk: String?
    ): Call<List<GetJobReplies>>

    @FormUrlEncoded
    @POST("v/expert_reply/ ")
    fun postJobReply(
        @Header("Authorization") authorizationToken: String,
        @Field("e_id") jobId: String?,
        @Field("data") replyData: String
    ): Call<PostJobReply>

    @FormUrlEncoded
    @POST("v/request_expert/")
    fun createNewJob(
        @Header("Authorization") authorizationToken: String,
        @Field("query") query: String,
        @Field("expert") expert: String,
        @Field("urgency") urgency: String
    ): Call<CreateNewJob>

    @FormUrlEncoded
    @POST("v/search_job/")
    fun searchJob(
        @Header("Authorization") authorizationToken: String,
        @Field("data") data: String
    ): Call<List<JobDataItem>>
}