package com.fastestindia.thedatatalk.APIs

import com.fastestindia.thedatatalk.CollabActivities.CollabDataItem
import com.fastestindia.thedatatalk.CollabActivities.CreateNewCollab
import com.fastestindia.thedatatalk.CollabActivities.GetCollabReplies
import com.fastestindia.thedatatalk.CollabActivities.PostCollabReply
import retrofit2.Call
import retrofit2.http.*

interface CollabAPI {
    @get:GET("v/get_collab/")
    val collabDetails: Call<List<CollabDataItem>>

    @FormUrlEncoded
    @POST("v/collect_colab_reply/ ")
    fun getCollabReply(
        @Header("Authorization") authorizationToken: String,
        @Field("pk") pk: String?
    ): Call<List<GetCollabReplies>>

    @FormUrlEncoded
    @POST("v/colab_reply/ ")
    fun postCollabReply(
        @Header("Authorization") authorizationToken: String,
        @Field("c_id") collabId: String?,
        @Field("data") replyData: String
    ): Call<PostCollabReply>

    @FormUrlEncoded
    @POST("v/request_colab/")
    fun createNewCollab(
        @Header("Authorization") authorizationToken: String,
        @Field("partno") noOfPerson: String,
        @Field("title") title: String,
        @Field("desc") desc: String
    ): Call<CreateNewCollab>

    @FormUrlEncoded
    @POST("v/search_colab/")
    fun searchCollab(
        @Header("Authorization") authorizationToken: String,
        @Field("data") data: String
    ): Call<List<CollabDataItem>>
}