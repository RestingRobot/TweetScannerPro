package com.restingrobot.tweetscannerpro.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.restingrobot.tweetscannerpro.model.Tweet
import com.restingrobot.tweetscannerpro.network.TwitterService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 *
 * PagingSource that uses next_token key returned in search result meta
 *
 * Created by Jon Lange, 5/12/21
 */
class TweetPagingSource @Inject constructor(
	private val service: TwitterService,
	private val query: String
) : PagingSource<String, Tweet>() {

	override fun getRefreshKey(state: PagingState<String, Tweet>): String? {
		return state.anchorPosition?.let { anchorPosition ->
			state.closestPageToPosition(anchorPosition)?.prevKey
		}
	}

	override suspend fun load(params: LoadParams<String>): LoadResult<String, Tweet> {
		return try {
			val data = service.searchTweets(
				query = this.query, null, null,
				if (params is LoadParams.Append) params.key else null
			)

			LoadResult.Page(
				data = data.tweets,
				nextKey = data.meta.nextToken,
				prevKey = null
			)

		} catch (e: IOException) {
			LoadResult.Error(e)
		} catch (e: HttpException) {
			LoadResult.Error(e)
		}
	}


}
