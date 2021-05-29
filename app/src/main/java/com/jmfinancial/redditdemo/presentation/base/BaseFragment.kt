package com.jmfinancial.redditdemo.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.jmfinancial.redditdemo.R


/**
 * Created by Vijay on 28/5/21.
 */

abstract class BaseFragment : Fragment() {

    var dialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(activity).inflate(getLayout(), container, false)
        return view
    }

    abstract fun getLayout(): Int


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
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            ?.replace(containerViewId, fragment)
            ?.commit()
    }

}