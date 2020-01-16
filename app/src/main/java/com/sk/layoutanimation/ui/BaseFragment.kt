package com.sk.layoutanimation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.sk.layoutanimation.R
import com.sk.layoutanimation.ui.models.MovieItem
import com.sk.layoutanimation.ui.viewmodel.ListItemViewModel

open class BaseFragment : Fragment() {

    val movieList = arrayListOf<MovieItem>()
    lateinit var listViewModel: ListItemViewModel

    lateinit var movieListView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listViewModel = ViewModelProviders.of(this).get(ListItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container,false)
        movieListView = rootView.findViewById(R.id.movieList)
        return rootView
    }
}