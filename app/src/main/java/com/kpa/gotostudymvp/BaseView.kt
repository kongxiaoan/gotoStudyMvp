package com.kpa.gotostudymvp

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
interface BaseView<E> {
    fun setPresenter(presenter: E)
}