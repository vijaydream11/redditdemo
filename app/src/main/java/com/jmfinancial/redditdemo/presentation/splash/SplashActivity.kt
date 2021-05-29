package com.jmfinancial.redditdemo.presentation.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.jmfinancial.redditdemo.R
import com.jmfinancial.redditdemo.presentation.base.BaseActivity
import com.jmfinancial.redditdemo.presentation.base.HomePresenter
import com.jmfinancial.redditdemo.presentation.utils.Navigator


/**
 * Created by Vijay on 28/5/21.
 */

class SplashActivity : BaseActivity() {

    companion object {
        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, SplashActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Navigator.navigateToHome(this)

    }

}