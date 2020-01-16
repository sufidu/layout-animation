package com.sk.layoutanimation.ui

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sk.layoutanimation.R
import com.sk.layoutanimation.ui.models.MovieItem

class MovieItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val container: ConstraintLayout = view.findViewById(R.id.container)
    private val movieTitle: AppCompatTextView = view.findViewById(R.id.tvMovieTitle)
    private val movieDescription: AppCompatTextView = view.findViewById(R.id.tvMovieDescription)
    val movieIcon: AppCompatImageView = view.findViewById(R.id.ivMovieIcon)

    fun bind(movieItem: MovieItem) {
        movieTitle.text = movieItem.title
        movieDescription.text = movieItem.description
        val imageResource = itemView.resources.getIdentifier(movieItem.icon, "drawable", itemView.context.packageName)
        movieIcon.setImageResource(imageResource)
    }
}