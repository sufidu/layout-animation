package com.sk.layoutanimation.ui.fade_slideright

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sk.layoutanimation.ui.BaseFragment

class FadeSlideRightFragment: BaseFragment() {

    lateinit var fadeSlideRightListAdapter: FadeSlideRightListAdapter

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
                fadeSlideRightListAdapter.notifyDataSetChanged()
            }
        })
        fadeSlideRightListAdapter = FadeSlideRightListAdapter(movieList)
        movieListView.adapter = fadeSlideRightListAdapter
        return rootView
    }
}