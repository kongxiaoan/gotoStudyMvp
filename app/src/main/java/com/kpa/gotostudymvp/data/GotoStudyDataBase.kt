package com.kpa.gotostudymvp.data

import com.kpa.gotostudymvp.home.HomeData

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
interface GotoStudyDataBase<T> {
    interface LoadDataCallback<T> {
        fun onDataLoaded(success: Boolean, list: MutableList<T>)
        fun onDataLoadError()
    }

    fun getLoadCallback(callback: LoadDataCallback<T>)
}