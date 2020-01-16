package com.sk.layoutanimation.ui.slidedown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sk.layoutanimation.ui.BaseFragment

class SlideDownLayoutFragment : BaseFragment() {

    lateinit var slideDownListAdapter: SlideDownListAdapter

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
                slideDownListAdapter.notifyDataSetChanged()
            }
        })
        slideDownListAdapter = SlideDownListAdapter(movieList)
        movieListView.adapter = slideDownListAdapter
        return rootView
    }
}