package com.kpa.gotostudymvp.net.packagenet

import com.kpa.gotostudymvp.data.MovieSubject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 *author: mr.kong
 *Date:2018/9/19
 *description:
 *project name:gotoStudyMvp
 **/
interface GotoService {
    @GET("top250")
    fun getTop250(@Query("start") start: Int,
                  @Query("count") count: Int): Call<MovieSubject>

    @GET("top250")
    fun getTop250Rxjava(@Query("start") start: Int,
                        @Query("count") count: Int): Observable<MovieSubject>
}