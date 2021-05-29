package com.jmfinancial.redditdemo

import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho

/**
 * Created by Vijay on 28/5/21.
 */

class RedditDemoApplication : MultiDexApplication() {


    companion object {

        var mAppContext: RedditDemoApplication? = null

        fun getAppInstance(): RedditDemoApplication? {
            return mAppContext
        }

    }

    override fun onCreate() {
        super.onCreate()
        mAppContext = this
        Stetho.initializeWithDefaults(this)


    }


}