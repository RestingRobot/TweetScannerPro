package com.restingrobot.tweetscannerpro.model


/**
 *
 * Data Class for a tweet search request and response
 *
 * Created by Jon Lange, 5/12/21
 */
class TweetSearchResponse(var tweets: List<Tweet>, var meta: SearchMeta) {
}
