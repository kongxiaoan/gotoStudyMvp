package com.kpa.gotostudymvp.home

import com.kpa.gotostudymvp.data.GotoStudyDataBase
import com.kpa.gotostudymvp.data.GotoStudyRepository
import com.kpa.gotostudymvp.data.MovieSubject

/**
 *author: mr.kong
 *Date:2018/9/18
 *description: 加载数据和更新UI
 *project name:gotoStudyMvp
 **/
class HomePresenter(private var mHomeView: HomeContract.View, private var mGotoStudyRepository: GotoStudyRepository) : HomeContract.Presenter {

    init {
        this.mHomeView.setPresenter(this)
    }

    private fun loadData() {
       mGotoStudyRepository.getLoadCallback(object :GotoStudyDataBase.LoadDataCallback<MovieSubject>{
           override fun onDataLoaded(success: Boolean, list: MutableList<MovieSubject>) {
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