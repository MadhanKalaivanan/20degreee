package com.t.a20degree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.t.a20degree.model.TwitterModel
import com.t.a20degree.network.NetworkState
import com.t.a20degree.repository.TwitterRepository
import kotlinx.coroutines.launch

class TwitterViewModel(private val twitterRepository: TwitterRepository): ViewModel() {

    private val _data = MutableLiveData<TwitterModel>()
    val data: LiveData<TwitterModel>
        get() = _data

    fun getDataFeed(pageNo: Int, dataPerPage: Int) {

        viewModelScope.launch {
            when (val response = twitterRepository.getFeeds(pageNo, dataPerPage)) {
                is NetworkState.Success -> {
                    _data.postValue(response.data)
                }
                is NetworkState.Error -> {
                    if (response.response.code() == 401) {
                        //_data.postValue(NetworkState.Error())
                    } else {
                        //_data.postValue(NetworkState.Error)
                    }
                }
            }
        }
    }

    fun reTweetClicked(){
        _data.value?.retweet = _data.value?.retweet != true
    }

    fun isRead(){
        _data.value?.isRead = true
    }

    fun checkImageAndVideo(){
        if(!_data.value?.imageUrl.isNullOrEmpty()){
            //load image and hide video
        }else if(!_data.value?.videoUrl.isNullOrEmpty()){
            //load video and hide image
        }else{
            //hide both vide and audio
        }
    }


}