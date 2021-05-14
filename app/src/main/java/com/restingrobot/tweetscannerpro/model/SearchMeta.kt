package com.restingrobot.tweetscannerpro.model

import com.google.gson.annotations.SerializedName


/**
 *
 * Search Metadata Returned from a search request.
 *
 * Created by Jon Lange, 5/11/21
 */
data class SearchMeta(
	@SerializedName("newest_id")
	var newestId: String,
	@SerializedName("oldest_id")
	var oldestId: String,
	@SerializedName("result_count")
	var resultCount: Int,
	@SerializedName("next_token")
	var nextToken: String? = null
)
