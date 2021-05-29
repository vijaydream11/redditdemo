package com.jmfinancial.redditdemo.data

import android.content.Context
import android.content.SharedPreferences
import com.jmfinancial.redditdemo.RedditDemoApplication
import com.jmfinancial.redditdemo.R


/**
 * Created by Vijay on 28/5/21.
 */

object SharedPreferenceManager {

    // key used in the app
    val KEY_SHOULD_NOT_SHOW_WALKTHROUGH = "shouldShowWalkthrough"


    var sharedPreferenceManger: SharedPreferenceManager? = null
    var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = RedditDemoApplication.getAppInstance()
            ?.getSharedPreferences(
                RedditDemoApplication.getAppInstance()?.getString(R.string.preference_name),
                Context.MODE_PRIVATE
            )
    }

    fun saveString(key: String, value: String) {
        val editor = sharedPreferences?.edit()
        editor?.putString(key, value)
        editor?.commit()
        editor?.apply()
    }

    fun containsKey(key: String): Boolean? {
        return sharedPreferences?.contains(key)
    }

    fun getString(key: String): String? {
        return sharedPreferences?.getString(key, "")
    }

    fun saveInt(key: String, value: Int) {
        sharedPreferences?.edit()?.putInt(key, value)?.apply()
    }

    fun getInt(key: String): Int? {
        return sharedPreferences?.getInt(key, 0)
    }

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences?.edit()?.putBoolean(key, value)?.apply()
    }

    fun getBoolean(key: String): Boolean? {
        return sharedPreferences?.getBoolean(key, false)
    }

    fun saveLong(key: String, value: Long) {
        sharedPreferences?.edit()?.putLong(key, value)?.apply()
    }

    fun getLong(key: String): Long? {
        return sharedPreferences?.getLong(key, 0L)
    }



    fun clearData() {
        val editor = sharedPreferences?.edit()
        editor?.clear()
        editor?.commit()
    }

}