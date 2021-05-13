package com.restingrobot.tweetscannerpro.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.restingrobot.tweetscannerpro.model.Tweet
import com.restingrobot.tweetscannerpro.network.TwitterService
import com.restingrobot.tweetscannerpro.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


/**
 *
 * Common view model for all features using tweets
 *
 * Created by Jon Lange, 5/11/21
 */
@HiltViewModel
class TweetViewModel @Inject constructor(private val tweetRepository: TweetRepository,
private val savedStateHandle: SavedStateHandle) : ViewModel() {

	private val clearListChannel = Channel<Unit>(Channel.CONFLATED)

	@FlowPreview
	@ExperimentalCoroutinesApi
	val tweets = flowOf(
		clearListChannel.receiveAsFlow().map { PagingData.empty<Tweet>() },
		savedStateHandle.getLiveData<String>(KEY_QUERY)
			.asFlow()
			.flatMapLatest { tweetRepository.searchTweets(it) }
			.cachedIn(viewModelScope)
	).flattenMerge(2)

	fun shouldDoSearch(query: String) = savedStateHandle.get<String>(KEY_QUERY) != query

	fun doSearch(query: String) {
		if(!shouldDoSearch(query)) return

		clearListChannel.offer(Unit)

		savedStateHandle.set(KEY_QUERY, query)
	}

	companion object {
		const val KEY_QUERY = "query"
	}
}
