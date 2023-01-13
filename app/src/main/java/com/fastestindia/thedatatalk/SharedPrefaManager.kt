package com.fastestindia.thedatatalk

import android.content.Context
import android.content.SharedPreferences
import com.fastestindia.thedatatalk.APIs.Authorization
import com.fastestindia.thedatatalk.APIs.RefreshUser
import com.fastestindia.thedatatalk.APIs.User
import com.fastestindia.thedatatalk.QueryActivities.QueryReplyData

class SharedPrefaManager(var context: Context) {
    lateinit private var sharedPreferences: SharedPreferences
    lateinit private var editor: SharedPreferences.Editor
    fun saveAuthorization(authorization: String) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.putString("Authorization", authorization)
        editor.apply()
    }

    fun saveQueryId(queryId: String) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.putString("q_id", queryId)
        editor.apply()
    }

    fun saveUser(user: User) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.putString("username", user.username)
        editor.putString("password", user.password)
        editor.putString("firstname", user.firstname)
        editor.putString("lastname", user.lastname)
        editor.putString("contact", user.contact)
        editor.putString("designation", user.designation)
        editor.putString("company", user.company)
        editor.putString("experience", user.experience)
        editor.putString("college", user.college)
        editor.putString("stream", user.stream)
        editor.putString("start_date", user.start_date)
        editor.putString("end_date", user.end_date)
        editor.putString("profile_brief", user.profile_brief)
        editor.putString("workshop", user.workshop)
        editor.putString("su", user.su)
        editor.putString("invite_code", user.invite_code)
        editor.putString("ic_usage", user.ic_usage)
        editor.putBoolean("logged", true)
        editor.apply()
    }

    fun saveRefreshUser(user: RefreshUser) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.putString("username", user.username)
        editor.putString("firstname", user.firstname)
        editor.putString("lastname", user.lastname)
        editor.putString("contact", user.contact)
        editor.putString("designation", user.designation)
        editor.putString("company", user.company)
        editor.putString("experience", user.experience)
        editor.putString("college", user.college)
        editor.putString("stream", user.stream)
        editor.putString("start_date", user.start_date)
        editor.putString("end_date", user.end_date)
        editor.putString("profile_brief", user.profile_brief)
        editor.putString("workshop", user.workshop)
        editor.putString("su", user.su)
        editor.putString("invite_code", user.invite_code)
        editor.putString("ic_usage", user.ic_usage)
        editor.putBoolean("logged", true)
        editor.apply()
    }

    val isLoggedIn: Boolean
        get() {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean("logged", false)
        }
    val authorization: Authorization
        get() {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return Authorization(sharedPreferences.getString("Authorization",null).toString())
        }
    val queryId: QueryReplyData?
        get() {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getString("q_id", null)?.let { QueryReplyData(it) }
        }
    val user: User
        get() {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return User(
                sharedPreferences.getString("username", null),
                sharedPreferences.getString("password", null),
                sharedPreferences.getString("firstname", null),
                sharedPreferences.getString("lastname", null),
                sharedPreferences.getString("contact", null),
                sharedPreferences.getString("designation", null),
                sharedPreferences.getString("company", null),
                sharedPreferences.getString("experience", null),
                sharedPreferences.getString("college", null),
                sharedPreferences.getString("stream", null),
                sharedPreferences.getString("start_date", null),
                sharedPreferences.getString("end_date", null),
                sharedPreferences.getString("profile_brief", null),
                sharedPreferences.getString("workshop", null),
                sharedPreferences.getString("su", null),
                sharedPreferences.getString("invite_code", null),
                sharedPreferences.getString("ic_usage", null)
            )
        }

    val refreshUser: RefreshUser
        get() {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return RefreshUser(
                sharedPreferences.getString("username", null),
                sharedPreferences.getString("firstname", null),
                sharedPreferences.getString("lastname", null),
                sharedPreferences.getString("contact", null),
                sharedPreferences.getString("designation", null),
                sharedPreferences.getString("company", null),
                sharedPreferences.getString("experience", null),
                sharedPreferences.getString("college", null),
                sharedPreferences.getString("stream", null),
                sharedPreferences.getString("start_date", null),
                sharedPreferences.getString("end_date", null),
                sharedPreferences.getString("profile_brief", null),
                sharedPreferences.getString("workshop", null),
                sharedPreferences.getString("su", null),
                sharedPreferences.getString("invite_code", null),
                sharedPreferences.getString("ic_usage", null)
            )
        }

    fun logout() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private const val SHARED_PREF_NAME = "thedatatalk"
    }
}