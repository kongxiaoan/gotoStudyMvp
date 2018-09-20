package com.kpa.gotostudymvp.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpa.gotostudymvp.R
import com.kpa.gotostudymvp.data.MovieSubject
import com.kpa.gotostudymvp.data.Subject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 * 展示UI
 */
class HomeFragment : Fragment(), HomeContract.View {
    private lateinit var mPersenter: HomeContract.Presenter
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: HomeCustomAdapter? = null
    private var mList: MutableList<Subject> = arrayListOf()
    override fun isAlive(): Boolean {
        return isAdded //判断片段是否已经添加到其活动中
    }

    override fun isLoading(isLoading: Boolean) {

    }

    override fun loadError() {

    }

    override fun loadSuccess(data: MutableList<MovieSubject>) {
        val subjects = data[0].subjects
        mList.addAll(subjects)
        mAdapter?.notifyDataSetChanged()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initRv()
    }

    private fun initRv() {


    }

    private fun initView(view: View) {
        mAdapter = HomeCustomAdapter(context!!, mList)
        mRecyclerView = view.findViewById(R.id.home_fragment_rv)
        mRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = mAdapter
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
