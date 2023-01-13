package com.fastestindia.thedatatalk.APIs


import com.fastestindia.thedatatalk.EventsActivities.GetEventDetails
import retrofit2.Call
import retrofit2.http.GET

interface EventAPI {
    @get:GET("v/get_event/")
    val getEventDetails: Call<List<GetEventDetails>>
}