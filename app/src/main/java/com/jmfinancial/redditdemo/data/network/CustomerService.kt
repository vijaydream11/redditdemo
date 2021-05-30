package com.appwithmeflutter.mype.data.network


import com.jmfinancial.redditdemo.presentation.login.model.RedditPost
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

/**
 * Created by Vijay on 28/5/21.
 */
interface CustomerService {


    @GET("r/all/hot/.json")
    fun getAllPost(): Observable<RedditPost>

    @GET("comments/{id}/.json")
    fun getAllComments(@Query("id") id: String): Observable<RedditPost>

}