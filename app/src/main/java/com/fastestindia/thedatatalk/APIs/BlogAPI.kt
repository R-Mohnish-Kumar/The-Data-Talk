package com.fastestindia.thedatatalk.APIs

import com.fastestindia.thedatatalk.BlogActivities.CreateNewBlog
import com.fastestindia.thedatatalk.BlogActivities.GetBlogDetails

import retrofit2.Call
import retrofit2.http.*

interface BlogAPI {
    @get:GET("v/get_blog/")
    val getBlogDetails: Call<List<GetBlogDetails>>

    @FormUrlEncoded
    @POST("v/create_blog/")
    fun createNewCollab(
        @Header("Authorization") authorizationToken: String,
        @Field("title") title: String,
        @Field("editordata") desc: String
    ): Call<CreateNewBlog>

    @FormUrlEncoded
    @POST("v/search_blog/")
    fun searchBlog(
        @Header("Authorization") authorizationToken: String,
        @Field("data") data: String
    ): Call<List<GetBlogDetails>>
}