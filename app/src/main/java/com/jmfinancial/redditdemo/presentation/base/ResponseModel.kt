package com.jmfinancial.redditdemo.presentation.base

/**
 * Created by Vijay on 28/5/21.
 */

class ResponseModel<T>(var status: Int, var mResponse: T?, var error: Throwable?) {


    companion object {

        val SUCCESS = 201
        val ERROR = 202

        fun <T> setResponse(response: T): ResponseModel<T> {
            return ResponseModel(
                SUCCESS,
                response,
                null
            )
        }

        fun <T> setError(error: Throwable): ResponseModel<T> {
            return ResponseModel(
                ERROR,
                null,
                error
            )
        }
    }

}