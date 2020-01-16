package com.sk.layoutanimation.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.sk.layoutanimation.ui.models.MovieItem
import java.io.IOException
import java.nio.charset.Charset


class ListItemViewModel(application: Application) : AndroidViewModel(application) {

    private val _listItems = MutableLiveData<List<MovieItem>>().apply {
        var jsonString = ""
        try {
            val inputStream = application.assets.open("movie_data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
        }

        value = Gson().fromJson(jsonString, Array<MovieItem>::class.java).toList()
    }

    val listItems : LiveData<List<MovieItem>> = _listItems
}