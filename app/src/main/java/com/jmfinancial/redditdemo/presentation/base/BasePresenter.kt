package com.jmfinancial.redditdemo.presentation.base

import com.appwithmeflutter.mype.data.network.CustomerService
import com.jmfinancial.redditdemo.dataProvider.ApiService
import io.reactivex.rxjava3.disposables.CompositeDisposable


/**
 * Created by Vijay on 28/5/21.
 */
open class BasePresenter {

    var mCustomerService: CustomerService? = null
    var mCompositeDisposable: CompositeDisposable? = null

    open fun onCreate() {
        mCompositeDisposable = CompositeDisposable()
        mCustomerService = ApiService.getInstance()?.call()

    }

    open fun onDestroy() {

    }


}