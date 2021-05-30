package com.jmfinancial.redditdemo.presentation.login

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmfinancial.redditdemo.R
import com.jmfinancial.redditdemo.presentation.base.BaseActivity
import com.jmfinancial.redditdemo.presentation.base.HomePresenter
import com.jmfinancial.redditdemo.presentation.login.model.RedditPost
import com.jmfinancial.redditdemo.presentation.login.model.VoteModel
import kotlinx.android.synthetic.main.activity_home.*


/**
 * Created by Vijay on 28/5/21.
 */

class HomeActivity : BaseActivity(), HomeView, HomeAdapter.IHomeHandler {

    val mHomePresenter: HomePresenter by lazy {
        HomePresenter(this)
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mHomePresenter.onCreate()
        mHomePresenter.onPageLoad()
    }

    override fun onDestroy() {
        super.onDestroy()
        mHomePresenter.onDestroy()
    }

    override fun onGetAllPostSuccess(it: RedditPost) {
        hideProgress()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvRedditPost.layoutManager = linearLayoutManager
        val adapter = it.data?.listChildren?.let { data -> HomeAdapter(this, data, this) }
        rvRedditPost.adapter = adapter

    }

    override fun onGetAllPostFailure(it: Throwable) {
        hideProgress()
    }

    override fun onVoteSuccess(it: VoteModel) {
        hideProgress()
        showToastMessage(getString(R.string.error_sign_in))
    }

    override fun onVoteFailure(it: Throwable) {
        hideProgress()
    }

    override fun showLoading() {
        showProgress(this)
    }

    override fun hideLoading() {
        hideProgress()
    }

    override fun onUpVote(name: String?) {
        mHomePresenter.onVoteClicked(name, 1)
    }

    override fun onDownVote(name: String?) {
        mHomePresenter.onVoteClicked(name, 0)
    }


}