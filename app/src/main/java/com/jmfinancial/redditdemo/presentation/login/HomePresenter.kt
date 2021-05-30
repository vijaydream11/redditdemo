package com.jmfinancial.redditdemo.presentation.base

import com.jmfinancial.redditdemo.presentation.login.HomeView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Vijay on 28/5/21.
 */

class HomePresenter(val mHomeView: HomeView) : BasePresenter() {

    fun onPageLoad() {
        mCompositeDisposable?.add(
            mCustomerService?.getAllPost()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.doOnSubscribe {
                    mHomeView.showLoading()
                }
                ?.doOnError {
                    mHomeView.hideLoading()
                }
                ?.subscribe({
                    mHomeView.onGetAllPostSuccess(it)
                }, {
                    mHomeView.onGetAllPostFailure(it)
                })
        )
    }

    fun onVoteClicked(name: String?, direction: Int) {
        mCompositeDisposable?.add(
            name?.let {
                mCustomerService?.userVote(name, direction)
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.doOnSubscribe {
                        mHomeView.showLoading()
                    }
                    ?.doOnError {
                        mHomeView.hideLoading()
                    }
                    ?.subscribe({
                        mHomeView.onVoteSuccess(it)
                    }, {
                        mHomeView.onVoteFailure(it)
                    })
            }
        )
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable?.dispose()
    }


}