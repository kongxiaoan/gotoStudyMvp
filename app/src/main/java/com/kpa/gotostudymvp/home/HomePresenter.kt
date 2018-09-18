package com.kpa.gotostudymvp.home

import com.kpa.gotostudymvp.data.GotoStudyDataBase
import com.kpa.gotostudymvp.data.GotoStudyRepository

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
class HomePresenter(mHomeView: HomeContract.View, mGotoStudyRepository: GotoStudyRepository) : HomeContract.Presenter {

    private var mHomeView: HomeContract.View = mHomeView
    private var mGotoStudyRepository: GotoStudyRepository = mGotoStudyRepository

    init {
        this.mHomeView.setPresenter(this)

    }

    fun loadData() {
       mGotoStudyRepository.getLoadCallback(object :GotoStudyDataBase.LoadDataCallback<HomeData>{
           override fun onDataLoaded(success: Boolean, list: MutableList<HomeData>) {
               if(success){
                   mHomeView.loadSuccess(list)
               }
           }

           override fun onDataLoadError() {

           }
       })
    }

    override fun start() {
        loadData()
    }
}