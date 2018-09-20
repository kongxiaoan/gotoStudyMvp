package com.kpa.gotostudymvp.net.base

import com.kpa.gotostudymvp.data.GotoStudyDataBase
import com.kpa.gotostudymvp.data.MovieSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
object RetrofitManager {
    fun get(callback: GotoStudyDataBase.LoadDataCallback<MovieSubject>) {
        val movieService = BaseRetrofit.create().create(BaseMovieService::class.java)
        val call = movieService.getTop250(0, 20)
        call.enqueue(object : Callback<MovieSubject> {
            override fun onFailure(call: Call<MovieSubject>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieSubject>, response: Response<MovieSubject>) {
                val body = response.body()
                val list = arrayListOf<MovieSubject>()
                if (body != null) {
                    list.add(body)
                }
                callback.onDataLoaded(true, list)
            }

        })

    }

    fun getRxJava(callback: GotoStudyDataBase.LoadDataCallback<MovieSubject>) {
        val movieService = BaseRetrofit.hasRxjavaCreate().create(BaseMovieService::class.java)
        val subscription = movieService.getTop250Rxjava(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<MovieSubject>() {
                    override fun onNext(t: MovieSubject?) {
                        val list: MutableList<MovieSubject> = arrayListOf()
                        list.add(t!!)
                        callback.onDataLoaded(true, list)
                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })

    }

    fun post(callback: GotoStudyDataBase.LoadDataCallback<MovieSubject>) {

    }
}