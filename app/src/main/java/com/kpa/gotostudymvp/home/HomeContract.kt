package com.kpa.gotostudymvp.home

import com.kpa.gotostudymvp.BasePresenter
import com.kpa.gotostudymvp.BaseView

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
interface HomeContract {
    interface View : BaseView<Presenter> {
        //正在加载
        fun isLoading(isLoading: Boolean)

        //加载错误
        fun loadError()

        //加载成功
        fun loadSuccess(data:MutableList<HomeData>)

        //网络错误
        fun networkError()

        fun isAlive():Boolean
    }

    /**
     * 获取数据并且调用View更新
     */
    interface Presenter : BasePresenter {
//        fun data()
    }
}