package com.sk.layoutanimation.ui.slideup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sk.layoutanimation.ui.BaseFragment

class SlideUpLayoutFragment : BaseFragment() {

    lateinit var slideUpListAdapter: SlideUpListAdapter

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
                slideUpListAdapter.notifyDataSetChanged()
            }
        })
        slideUpListAdapter = SlideUpListAdapter(movieList)
        movieListView.adapter = slideUpListAdapter
        return rootView
    }
}