package com.restingrobot.tweetscannerpro.ui.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.restingrobot.tweetscannerpro.ui.tweetsearch.NetworkStateViewHolder


/**
 *
 * Adapter for displaying load states
 *
 * Created by Jon Lange, 5/11/21
 */
class TweetsLoadStateAdapter(private val adapter: TweetAdapter) :
	LoadStateAdapter<NetworkStateViewHolder>() {

	override fun onBindViewHolder(holder: NetworkStateViewHolder, loadState: LoadState) {
		holder.bindTo(loadState)
	}

	override fun onCreateViewHolder(
		parent: ViewGroup,
		loadState: LoadState
	): NetworkStateViewHolder {
		return NetworkStateViewHolder(parent) { adapter.retry() }
	}
}
