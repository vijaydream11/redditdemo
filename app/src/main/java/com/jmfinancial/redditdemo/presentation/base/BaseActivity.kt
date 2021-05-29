package com.jmfinancial.redditdemo.presentation.base


import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appwithmeflutter.mype.data.network.CustomerService
import com.jmfinancial.redditdemo.dataProvider.ApiService
import com.google.gson.Gson
import com.jmfinancial.redditdemo.R
import kotlinx.android.synthetic.main.toolbar_dashboard.*


/**
 * Created by Vijay on 28/5/21.
 */
abstract class BaseActivity : AppCompatActivity() {


    var mCustomerService: CustomerService? = null
    var mVendorId = ""
    var dialog: AlertDialog? = null
    val gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        mCustomerService = ApiService.getInstance()?.call()
    }


    fun showAlertDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this, R.style.bottomSheetStyleWrapper)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(
            "OK",
            { dialog, which ->
            })
        builder.setNegativeButton(
            "Cancel",
            { dialog, which ->
                dialog.dismiss()
            })
        val dialog = builder.create()
        dialog.show()
    }


    fun showToastMessage(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun setToolbarWithTitle(title: String, showHamburger: Boolean) {

        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            if (showHamburger)
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_hamburger)

            val mToolBarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
            mToolBarTitle.setText(title)
        }
    }

    fun setToolbarHamburger(title: String) {

        if (toolbar != null) {
            setSupportActionBar(toolbar)
//            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_hamburger)
            hideBackArrow()

            val mToolBarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
            mToolBarTitle.setText(title)
        }
    }


    fun showBackArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun hideBackArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun showProgress(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setCancelable(false)
        builder.setView(R.layout.dialog_progress)
        dialog = builder.create()
        dialog!!.show()
    }

    fun hideProgress() {
        if (dialog?.isShowing == true) {
            dialog?.dismiss()
        }
    }

    fun replaceFragment(@IdRes containerViewId: Int, @NonNull fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(containerViewId, fragment)
            .commit()
    }


}