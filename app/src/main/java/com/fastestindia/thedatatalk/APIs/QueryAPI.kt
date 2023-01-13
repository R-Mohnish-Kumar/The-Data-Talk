package com.fastestindia.thedatatalk.APIs

import com.fastestindia.thedatatalk.QueryActivities.GetQueryDetails
import com.fastestindia.thedatatalk.QueryActivities.GetQueryReplies
import com.fastestindia.thedatatalk.QueryActivities.PostQueryReply
import com.fastestindia.thedatatalk.QueryActivities.CreateNewQuery
import retrofit2.Call
import retrofit2.http.*

interface QueryAPI {
    @get:GET("v/get_query/")
    val queryDetails: Call<List<GetQueryDetails>>

    @FormUrlEncoded
    @POST("v/collect_query_reply/")
    fun getQueryReply(
        @Header("Authorization") authorizationToken: String,
        @Field("pk") pk: String
    ): Call<List<GetQueryReplies>>

    @FormUrlEncoded
    @POST("v/post_queries_reply/")
    fun postQueryReply(
        @Header("Authorization") authorizationToken: String,
        @Field("q_id") queryId: String,
        @Field("data") replyData: String
    ): Call<PostQueryReply>

    @FormUrlEncoded
    @POST("v/create_query/")
    fun createNewQuery(
        @Header("Authorization") authorizationToken: String,
        @Field("keyword") keyword: String,
        @Field("title") title: String
    ): Call<CreateNewQuery>

    @FormUrlEncoded
    @POST("v/search_query/")
    fun searchQuery(
        @Header("Authorization") authorizationToken: String,
        @Field("data") data: String
    ): Call<List<GetQueryDetails>>
}