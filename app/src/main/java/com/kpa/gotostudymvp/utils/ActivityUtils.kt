package com.kpa.gotostudymvp.utils

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/
object ActivityUtils {

    fun addFragemtToActivity(@NonNull manager: FragmentManager,
                             @NonNull fragment: Fragment, fragmentId: Int) {
        checkNotNull(manager)
        checkNotNull(fragment)
        val beginTransaction = manager.beginTransaction()
        beginTransaction.add(fragmentId, fragment)
        beginTransaction.commit()
    }
}