package com.t.a20degree.repository

import com.t.a20degree.model.TwitterModel
import com.t.a20degree.network.NetworkState

class TwitterRepository {

    suspend fun getFeeds(pageNo: Int, dataPerPage: Int) : NetworkState<TwitterModel> {
        //we can use retrofit to get feeds
        return NetworkState.Success(TwitterModel())
    }

}