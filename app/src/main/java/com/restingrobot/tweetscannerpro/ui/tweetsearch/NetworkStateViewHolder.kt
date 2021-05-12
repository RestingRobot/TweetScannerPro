package com.restingrobot.tweetscannerpro.ui.tweetsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadState.Error
import androidx.paging.LoadState.Loading
import androidx.recyclerview.widget.RecyclerView
import com.restingrobot.tweetscannerpro.R
import com.restingrobot.tweetscannerpro.databinding.ItemNetworkStateBinding


/**
 *
 * View Holder that displays loading indicator or allows user to retry
 * page loading.
 *
 * Created by Jon Lange, 5/12/21
 */
class NetworkStateViewHolder(parent: ViewGroup,
							 private val retryCallback: () -> Unit
) : RecyclerView.ViewHolder(
		LayoutInflater.from(parent.context)
			.inflate(R.layout.item_network_state, parent, false)
) {
	private val binding = ItemNetworkStateBinding.bind(itemView)
	private val progressBar = binding.networkProgressBar
	private val errorMessage = binding.networkErrorMsg
	private val retry = binding.networkRetryButton
		.also {
			it.setOnClickListener {
				retryCallback
			}
		}

	fun bindTo(loadState: LoadState) {
		progressBar.isVisible = loadState is Loading
		retry.isVisible = loadState is Error
		errorMessage.isVisible = (loadState as? Error)?.error?.message.isNullOrBlank()
		errorMessage.text = (loadState as? Error)?.error?.message
	}

}
