package com.kpa.gotostudymvp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kpa.gotostudymvp.R
import com.kpa.gotostudymvp.data.GotoStudyRepository
import com.kpa.gotostudymvp.utils.ActivityUtils

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        //创建View
//        var homeFragment = supportFragmentManager.findFragmentById(R.id.home_container_fl) as HomeFragment
        val homeFragment = HomeFragment.getInstance()
        ActivityUtils.addFragemtToActivity(supportFragmentManager, homeFragment, R.id.home_container_fl)

        //创建Presenter
        HomePresenter(homeFragment, GotoStudyRepository())
    }
}
