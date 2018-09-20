package com.kpa.gotostudymvp.net.packagenet.loader

import com.kpa.gotostudymvp.data.MovieSubject
import com.kpa.gotostudymvp.net.packagenet.GotoService
import com.kpa.gotostudymvp.net.packagenet.GotoStudyServiceManager
import com.kpa.gotostudymvp.net.packagenet.ObjectLoader
import rx.Observable
import rx.functions.Func1

/**
 *author: mr.kong
 *Date:2018/9/19
 *description:
 *project name:gotoStudyMvp
 **/
class MovieLoader : ObjectLoader() {
    private var mService: GotoService

    init {
        mService = GotoStudyServiceManager.create(GotoService::class.java)
    }

    fun getMovie(start: Int, count: Int): Observable<MutableList<MovieSubject>> {
        return observe(mService.getTop250Rxjava(start, count)
                .map(object : Func1<MovieSubject, MutableList<MovieSubject>> {
                    override fun call(t: MovieSubject): MutableList<MovieSubject> {
                        val list: MutableList<MovieSubject> = arrayListOf()
                        list.add(t)
                        return list
                    }
                }))
    }
}