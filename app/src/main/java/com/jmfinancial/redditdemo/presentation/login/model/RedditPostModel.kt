package com.jmfinancial.redditdemo.presentation.login.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RedditPost() : Serializable {

    @SerializedName("data")
    @Expose
    val data: Dataa? = null

}

class Dataa {

    @SerializedName("children")
    @Expose
    val listChildren: List<Children> = ArrayList()

}

class Children {

    @SerializedName("data")
    @Expose
    val childrenData: ChildrenData? = null

}

class ChildrenData {

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("url")
    @Expose
    val thumbnail: String? = null

    @SerializedName("id")
    @Expose
    val commentId: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

}
