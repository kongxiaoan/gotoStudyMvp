package com.kpa.gotostudymvp.net.base

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
object BaseRetrofit {
    private val BASE_URL = "https://api.douban.com/v2/movie/"

    /**
     * 创建一个Retrofit
     */
    fun create(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    /**
     * 有RxJava 的时候的创建
     */
    fun hasRxjavaCreate(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RxJava
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun addOkHttp(): Retrofit {
        val builder = OkHttpClient.Builder()
                .readTimeout(5 * 1000, TimeUnit.SECONDS)
                .connectTimeout(5 * 1000, TimeUnit.SECONDS)
                .writeTimeout(5 * 1000, TimeUnit.SECONDS)
        return Retrofit.Builder().client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }
}