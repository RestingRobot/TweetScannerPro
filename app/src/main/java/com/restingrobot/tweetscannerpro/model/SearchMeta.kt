package com.restingrobot.tweetscannerpro.model


/**
 *
 * Search Metadata Returned from a search request.
 *
 * Created by Jon Lange, 5/11/21
 */
data class SearchMeta(
	val newestId: String,
	val oldestId: String,
	val resultCount: Int,
	val nextToken: String
	)
