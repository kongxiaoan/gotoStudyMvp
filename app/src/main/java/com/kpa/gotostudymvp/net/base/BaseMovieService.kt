package com.kpa.gotostudymvp.net.base

import com.kpa.gotostudymvp.data.MovieSubject
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
interface BaseMovieService {

    @GET("top250")
    fun getTop250(@Query("start") start: Int,
                  @Query("count") count: Int): Call<MovieSubject>

    @FormUrlEncoded
    @POST("top250")
    fun postTop250(@Field("start") start: Int
                   , @Field("count") count: Int): Call<MovieSubject>
    @GET("top250")
    fun getTop250Rxjava(@Query("start") start: Int,
                        @Query("count") count: Int): Observable<MovieSubject>

}