package com.t.a20degree.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.t.a20degree.repository.TwitterRepository

class TwitterViewModelFactory constructor(private val twitterRepository: TwitterRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TwitterViewModel::class.java)) {
            TwitterViewModel(this.twitterRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}