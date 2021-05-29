package com.jmfinancial.redditdemo.presentation.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jmfinancial.redditdemo.R
import com.jmfinancial.redditdemo.presentation.login.model.Children
import com.jmfinancial.redditdemo.presentation.utils.loadImage

class HomeAdapter(
    val mContext: Context,
    val mListChildren: List<Children>
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.adapter_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListChildren.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgPost = itemView.findViewById<ImageView>(R.id.imgPost)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)


        fun bind(position: Int) {
            val data = mListChildren.get(position).childrenData

            txtTitle.setText("" + data?.title)
            data?.thumbnail?.let {
                imgPost.loadImage(it)
            }

        }

    }

}