package com.jmfinancial.redditdemo.dataProvider

import com.appwithmeflutter.mype.data.network.CustomerService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by Vijay on 28/5/21.
 */

class ApiService {

    companion object {

        val BASE_URL = "http://api.mype.social/api/"


        var apiService: ApiService? = null
        private var retrofit: Retrofit? = null
        var services: CustomerService?= null

        fun getInstance(): ApiService? {

            if (apiService == null) {
                synchronized(ApiService::class.java) {

                    apiService = ApiService()
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    val httpClient = OkHttpClient.Builder()
                    httpClient.addInterceptor(interceptor)
                    httpClient.networkInterceptors().add(StethoInterceptor())
                    httpClient.connectTimeout(30, TimeUnit.SECONDS)
                    httpClient.writeTimeout(30, TimeUnit.SECONDS)
                    httpClient.readTimeout(30, TimeUnit.SECONDS)

                    httpClient.addInterceptor(object : Interceptor {
                        @Throws(IOException::class)
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val original = chain.request()
                            val requestBuilder = original.newBuilder()
                            val request = requestBuilder
                                .build()
                            return chain.proceed(request)
                        }
                    })

                    val gson = GsonBuilder()
                        .setLenient()
                        .create()
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build()
                }
            }
            return apiService
        }
    }

    fun call(): CustomerService? {
        services = retrofit?.create(CustomerService::class.java)
        return services
    }


}