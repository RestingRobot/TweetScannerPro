package com.restingrobot.tweetscannerpro.model

import com.google.gson.annotations.SerializedName


/**
 *
 * Model representation of a tweet
 *
 * Created by Jon Lange, 5/11/21
 */
data class Tweet(
	@SerializedName("author_id")
	val authorId: String,
	@SerializedName("id")
	val id: String,
	@SerializedName("text")
	val text: String
)
