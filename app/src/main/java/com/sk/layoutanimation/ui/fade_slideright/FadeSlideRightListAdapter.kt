package com.sk.layoutanimation.ui.fade_slideright

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.sk.layoutanimation.R
import com.sk.layoutanimation.ui.MovieItemViewHolder
import com.sk.layoutanimation.ui.models.MovieItem

class FadeSlideRightListAdapter(private val movieList: List<MovieItem>?) : RecyclerView.Adapter<MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {

        holder.container.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_left_to_right_animation)
        holder.movieIcon.animation = AnimationUtils.loadAnimation(holder.movieIcon.context, R.anim.fade_left_to_right_animation)

        holder.bind(movieList?.get(position) ?: MovieItem())
    }

    /* Clear all animation from views for faster scrolling */
    override fun onViewDetachedFromWindow(holder: MovieItemViewHolder) {
        holder.container.clearAnimation()
        holder.movieIcon.clearAnimation()
    }
}