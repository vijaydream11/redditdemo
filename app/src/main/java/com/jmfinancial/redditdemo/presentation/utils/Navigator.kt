package com.jmfinancial.redditdemo.presentation.utils

import android.content.Context
import com.jmfinancial.redditdemo.presentation.login.HomeActivity
import com.jmfinancial.redditdemo.presentation.splash.SplashActivity

object Navigator {


    fun navigateToHome(context: Context) {
        context.startActivity(HomeActivity.getCallingIntent(context))
    }


    fun navigateToSplash(context: Context) {
        context.startActivity(SplashActivity.getCallingIntent(context))
    }



}