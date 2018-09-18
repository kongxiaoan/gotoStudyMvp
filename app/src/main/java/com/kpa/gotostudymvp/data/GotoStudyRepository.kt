package com.kpa.gotostudymvp.data

import com.kpa.gotostudymvp.home.HomeData


/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
class GotoStudyRepository : GotoStudyDataBase<HomeData> {
    override fun getLoadCallback(callback: GotoStudyDataBase.LoadDataCallback<HomeData>) {
        val list = arrayListOf<HomeData>()
        list.add(HomeData("jack", 20))
        list.add(HomeData("tom", 20))
        list.add(HomeData("良辰", 20))
        list.add(HomeData("日天", 20))
        callback.onDataLoaded(true,list)
    }
}