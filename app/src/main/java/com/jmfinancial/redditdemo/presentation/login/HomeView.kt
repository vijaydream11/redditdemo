package com.jmfinancial.redditdemo.presentation.login

import com.jmfinancial.redditdemo.presentation.login.model.RedditPost
import com.jmfinancial.redditdemo.presentation.login.model.VoteModel

interface HomeView {

    fun onGetAllPostSuccess(it: RedditPost)

    fun onGetAllPostFailure(it: Throwable)

    fun onVoteSuccess(it: VoteModel)

    fun onVoteFailure(it: Throwable)

    fun showLoading()

    fun hideLoading()



}