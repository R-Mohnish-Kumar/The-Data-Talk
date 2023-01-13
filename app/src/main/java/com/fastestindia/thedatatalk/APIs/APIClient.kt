package com.fastestindia.thedatatalk.APIs

import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.JavaNetCookieJar
import java.net.CookieHandler
import java.net.CookieManager
import java.util.concurrent.TimeUnit

object APIClient {
    val retrofit: Retrofit
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val cookieHandler:CookieHandler = CookieManager()

            val okHttpClient: OkHttpClient =
                OkHttpClient.Builder()
                    .addNetworkInterceptor(httpLoggingInterceptor)
                    .cookieJar(JavaNetCookieJar(cookieHandler))
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://thedatatalk.org/")
                .client(okHttpClient)
                .build()
        }
    val service: com.fastestindia.thedatatalk.APIs.UserService
        get() = com.fastestindia.thedatatalk.APIs.APIClient.retrofit.create(com.fastestindia.thedatatalk.APIs.UserService::class.java)

    fun queryAPI(): com.fastestindia.thedatatalk.APIs.QueryAPI {
        return com.fastestindia.thedatatalk.APIs.APIClient.retrofit.create(com.fastestindia.thedatatalk.APIs.QueryAPI::class.java)
    }
    fun jobAPI(): com.fastestindia.thedatatalk.APIs.JobAPI {
        return com.fastestindia.thedatatalk.APIs.APIClient.retrofit.create(com.fastestindia.thedatatalk.APIs.JobAPI::class.java)
    }
    fun collabAPI(): com.fastestindia.thedatatalk.APIs.CollabAPI {
        return com.fastestindia.thedatatalk.APIs.APIClient.retrofit.create(com.fastestindia.thedatatalk.APIs.CollabAPI::class.java)
    }
    fun blogAPI(): BlogAPI {
        return retrofit.create(BlogAPI::class.java)
    }
    fun eventAPI() : EventAPI{
        return  retrofit.create((EventAPI::class.java))
    }
}