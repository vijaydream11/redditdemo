package com.jmfinancial.redditdemo.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.jmfinancial.redditdemo.presentation.base.LoginPresenter
import com.jmfinancial.redditdemo.R
import com.jmfinancial.redditdemo.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*


/**
 * Created by Vijay on 28/5/21.
 */

class LoginActivity : BaseActivity(), View.OnClickListener {

    val mLoginPresenter: LoginPresenter by lazy {
        LoginPresenter()
    }
    var mobileNum = ""
    var mTermsAndConditionSelected = false


    companion object {
        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txtGoogle.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.txtGoogle -> {

            }
        }
    }


}