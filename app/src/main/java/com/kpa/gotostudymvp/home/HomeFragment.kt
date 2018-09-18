package com.kpa.gotostudymvp.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kpa.gotostudymvp.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment(), HomeContract.View {
    private lateinit var mPersenter: HomeContract.Presenter
    override fun isAlive(): Boolean {
        return isAdded //判断片段是否已经添加到其活动中
    }

    override fun isLoading(isLoading: Boolean) {

    }

    override fun loadError() {

    }

    override fun loadSuccess(data: MutableList<HomeData>) {
        data.forEach {
            Log.e("HomeFragment", "name = ${it.name}")
        }
    }

    override fun networkError() {

    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
        mPersenter = presenter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onResume() {
        super.onResume()
        mPersenter.start()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }

    companion object {
        fun getInstance() = HomeFragment()
    }
}
