package com.jmfinancial.redditdemo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appwithmeflutter.mype.data.network.CustomerService
import com.jmfinancial.redditdemo.data.SharedPreferenceManager
import com.jmfinancial.redditdemo.dataProvider.ApiService
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by Vijay on 28/5/21.
 */

abstract class BaseBottomSheet : BottomSheetDialogFragment() {

    var mCustomerService: CustomerService? = null
    var mSharedPreferenceManager: SharedPreferenceManager? = null

    init {
        mCustomerService = ApiService.getInstance()?.call()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = LayoutInflater.from(activity).inflate(getLayout(), container, false)
        return view
    }



    abstract fun getLayout(): Int

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun showToastMessage(msg: String?) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

}