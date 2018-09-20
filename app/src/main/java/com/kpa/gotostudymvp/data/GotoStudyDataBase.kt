package com.kpa.gotostudymvp.data

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