package com.restingrobot.tweetscannerpro.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.restingrobot.tweetscannerpro.network.TwitterService
import javax.inject.Inject


/**
 *
 *
 *
 * Created by Jon Lange, 5/12/21
 */
class TweetRepository @Inject constructor(private val service: TwitterService) {

	fun searchTweets(query: String) = Pager(PagingConfig(10)) {
		TweetPagingSource(service, query)
	}.flow

}
