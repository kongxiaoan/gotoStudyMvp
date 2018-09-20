package com.kpa.gotostudymvp.data

import com.kpa.gotostudymvp.net.base.RetrofitManager
import com.kpa.gotostudymvp.net.packagenet.loader.MovieLoader
import rx.functions.Action
import rx.functions.Action1


/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
class GotoStudyRepository : GotoStudyDataBase<MovieSubject> {
    override fun getLoadCallback(callback: GotoStudyDataBase.LoadDataCallback<MovieSubject>) {
//        val list = arrayListOf<HomeData>()
//        list.add(HomeData("jack", 20))
//        list.add(HomeData("tom", 20))
//        list.add(HomeData("良辰", 20))
//        list.add(HomeData("日天", 20))
//        callback.onDataLoaded(true,list)
//        RetrofitManager.get(callback)
//        RetrofitManager.getRxJava(callback)
        MovieLoader().getMovie(20, 20).subscribe(object : Action1<MutableList<MovieSubject>> {
            override fun call(t: MutableList<MovieSubject>) {
                callback.onDataLoaded(true, t)
            }

        }, object : Action1<Throwable> {
            override fun call(t: Throwable?) {

            }

        })
    }
}