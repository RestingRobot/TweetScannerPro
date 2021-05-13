package com.restingrobot.tweetscannerpro.model

import com.google.gson.annotations.SerializedName


/**
 *
 * Data Class for a tweet search request and response
 *
 * Created by Jon Lange, 5/12/21
 */
class TweetSearchResponse(
	@SerializedName("data")
	var tweets: List<Tweet>,
	@SerializedName("meta")
	var meta: SearchMeta) {
}
