package com.restingrobot.tweetscannerpro.ui.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.restingrobot.tweetscannerpro.model.Tweet
import com.restingrobot.tweetscannerpro.ui.tweetsearch.TweetViewHolder


/**
 *
 * Simple adapter that shows tweets
 *
 * Created by Jon Lange, 5/11/21
 */
class TweetAdapter : PagingDataAdapter<Tweet, TweetViewHolder>(TWEET_COMPARATOR) {

	override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
		return TweetViewHolder.create(parent)
	}

	companion object {
		val TWEET_COMPARATOR = object : DiffUtil.ItemCallback<Tweet>() {

			override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet): Boolean =
				oldItem.id == newItem.id

			override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet): Boolean =
				oldItem == newItem
		}
	}

}
