package com.fastestindia.thedatatalk.APIs

import retrofit2.Retrofit
import kotlin.jvm.Synchronized
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    val api: APIClient
        get() = retrofit.create(APIClient::class.java)

    companion object {
        private const val Base_url = "http://thedatatalk.org/"
        private var retrofitClient: RetrofitClient? = null
        private lateinit var retrofit: Retrofit

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}