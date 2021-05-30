package com.jmfinancial.redditdemo.presentation.login

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.IntentCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmfinancial.redditdemo.R
import com.jmfinancial.redditdemo.presentation.base.BaseActivity
import com.jmfinancial.redditdemo.presentation.base.HomePresenter
import com.jmfinancial.redditdemo.presentation.login.model.RedditPost
import kotlinx.android.synthetic.main.activity_home.*


/**
 * Created by Vijay on 28/5/21.
 */

class HomeActivity : BaseActivity(), View.OnClickListener, HomeView {

    val mHomePresenter: HomePresenter by lazy {
        HomePresenter(this)
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            intent.addFlags(
                FLAG_ACTIVITY_NEW_TASK or
                        FLAG_ACTIVITY_CLEAR_TASK
            )
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mHomePresenter.onCreate()
        mHomePresenter.onPageLoad()
    }

    override fun onClick(view: View?) {
        when (view?.id) {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mHomePresenter.onDestroy()
    }

    override fun onSuccess(it: RedditPost) {
        Log.d("VIJAY------", "onSuccess" + it)
        hideProgress()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvRedditPost.layoutManager = linearLayoutManager
        val adapter = it.data?.listChildren?.let { data -> HomeAdapter(this, data) }
        rvRedditPost.adapter = adapter

    }

    override fun onFailure(it: Throwable) {
        hideProgress()
        Log.d("VIJAY------", "onFailure")
    }

    override fun showLoading() {
        showProgress(this)
    }

    override fun hideLoading() {
        hideProgress()
    }


}