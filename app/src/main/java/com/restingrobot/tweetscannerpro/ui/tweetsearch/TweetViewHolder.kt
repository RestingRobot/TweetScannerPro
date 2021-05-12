package com.restingrobot.tweetscannerpro.ui.tweetsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.restingrobot.tweetscannerpro.R
import com.restingrobot.tweetscannerpro.model.Tweet


/**
 *
 * Recycler ViewHolder that displays a tweet
 *
 * Created by Jon Lange, 5/11/21
 */
class TweetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

	private var tweet: Tweet? = null

	private val text: TextView = view.findViewById(R.id.tweet_text)
	private val id: TextView = view.findViewById(R.id.tweet_id)

	init {
	    view.setOnClickListener {
	    	// TODO: Set click listener when user taps tweet
		}
	}

	fun bind(tweet: Tweet?) {
		this.tweet = tweet

		// TODO: Format these better
		text.text = tweet?.text ?: "Loading..."
		id.text = tweet?.id ?: "Unknown"

		// TODO: Add fields if I have time
	}

	companion object {
		fun create(parent: ViewGroup): TweetViewHolder {
			val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tweet, parent, false)
			return TweetViewHolder(view)
		}
	}

}
