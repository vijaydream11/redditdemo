package com.jmfinancial.redditdemo.presentation.login

import com.jmfinancial.redditdemo.presentation.login.model.RedditPost

interface HomeView {

    fun onSuccess(it: RedditPost)

    fun onFailure(it: Throwable)

    fun showLoading()

    fun hideLoading()



}