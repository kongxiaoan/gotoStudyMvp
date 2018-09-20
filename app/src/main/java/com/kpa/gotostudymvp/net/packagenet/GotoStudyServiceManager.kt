package com.kpa.gotostudymvp.net.packagenet

import com.kpa.gotostudymvp.GtoStyConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *author: mr.kong
 *Date:2018/9/19
 *description:
 *project name:gotoStudyMvp
 **/
object GotoStudyServiceManager {
    private const val DEFAULT_TIME = 5L
    private const val DEFAULT_READ_ITEM_OUT = 10L

    private val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_READ_ITEM_OUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_READ_ITEM_OUT, TimeUnit.SECONDS)

    private var mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl(GtoStyConfig.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }
}