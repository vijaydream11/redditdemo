package com.jmfinancial.redditdemo.presentation.login.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VoteModel : Serializable {

    @SerializedName("json")
    @Expose
    val data: JsonData? = null

}

class JsonData {


}
