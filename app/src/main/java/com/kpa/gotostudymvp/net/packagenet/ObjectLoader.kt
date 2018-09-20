package com.kpa.gotostudymvp.net.packagenet

import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 *author: mr.kong
 *Date:2018/9/19
 *description:
 *project name:gotoStudyMvp
 **/
open class ObjectLoader {
    fun <T> observe(observable: Observable<T>): Observable<T> {
        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}