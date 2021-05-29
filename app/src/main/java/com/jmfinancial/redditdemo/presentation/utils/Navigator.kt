package com.jmfinancial.redditdemo.presentation.utils

import android.content.Context
import com.jmfinancial.redditdemo.presentation.login.LoginActivity
import com.jmfinancial.redditdemo.presentation.splash.SplashActivity

object Navigator {


    fun navigateToLogin(context: Context) {
        context.startActivity(LoginActivity.getCallingIntent(context))
    }


    fun navigateToSplash(context: Context) {
        context.startActivity(SplashActivity.getCallingIntent(context))
    }



}