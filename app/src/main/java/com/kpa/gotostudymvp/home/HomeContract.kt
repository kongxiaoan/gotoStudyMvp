package com.kpa.gotostudymvp.home

import com.kpa.gotostudymvp.BasePresenter
import com.kpa.gotostudymvp.BaseView
import com.kpa.gotostudymvp.data.MovieSubject

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:定义UI中的状态和数据操作
 *project name:gotoStudyMvp
 **/
interface HomeContract {
    interface View : BaseView<Presenter> {
        //正在加载
        fun isLoading(isLoading: Boolean)

        //加载错误
        fun loadError()

        //加载成功
        fun loadSuccess(data:MutableList<MovieSubject>)

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