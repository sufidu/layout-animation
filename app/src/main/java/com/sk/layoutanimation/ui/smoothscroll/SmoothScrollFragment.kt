package com.sk.layoutanimation.ui.smoothscroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sk.layoutanimation.ui.BaseFragment

class SmoothScrollFragment : BaseFragment() {

    lateinit var smoothScrollListAdapter: SmoothScrollListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)
        listViewModel.listItems.observe(this, Observer {
            it?.apply {
                movieList.clear()
                movieList.addAll(this)
                smoothScrollListAdapter.notifyDataSetChanged()
            }
        })
        smoothScrollListAdapter = SmoothScrollListAdapter(movieList)
        movieListView.adapter = smoothScrollListAdapter
        return rootView
    }
}