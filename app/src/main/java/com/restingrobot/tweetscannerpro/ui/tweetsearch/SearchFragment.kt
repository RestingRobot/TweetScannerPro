package com.restingrobot.tweetscannerpro.ui.tweetsearch

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.restingrobot.tweetscannerpro.databinding.FragmentSearchBinding
import com.restingrobot.tweetscannerpro.ui.adapter.TweetAdapter
import com.restingrobot.tweetscannerpro.ui.adapter.TweetsLoadStateAdapter
import com.restingrobot.tweetscannerpro.ui.base.BaseFragment
import com.restingrobot.tweetscannerpro.ui.viewmodel.TweetViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, TweetViewModel>() {

	override val viewModel: TweetViewModel by activityViewModels()

	private lateinit var adapter: TweetAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setHasOptionsMenu(false)

		initAdapter()
		initSwipeToRefresh()
		initSearch()
	}

	private fun initAdapter() {
		adapter = TweetAdapter()
		binding.list.adapter = adapter.withLoadStateHeaderAndFooter(
			header = TweetsLoadStateAdapter(adapter),
			footer = TweetsLoadStateAdapter(adapter)
		)

		// Handle SwipeRefresh
		lifecycleScope.launchWhenCreated {
			adapter.loadStateFlow.collectLatest { loadStates ->
				binding.searchSwipeRefresh.isRefreshing = loadStates.refresh is LoadState.Loading
			}
		}

		lifecycleScope.launchWhenCreated {
			viewModel.tweets.collectLatest {
				adapter.submitData(it)
			}
		}

		// Listen for RemoteMediator changes and only emit when a refresh is
		// LoadState is detected. (This will retain the tweet history as pages
		// are loaded in). When refreshed, resets list position and sets data
		lifecycleScope.launchWhenCreated {
			adapter.loadStateFlow
				.distinctUntilChangedBy { it.refresh }
				.filter { it.refresh is LoadState.NotLoading }
				.collect { binding.list.scrollToPosition(0) }
		}
	}

	private fun initSwipeToRefresh() {
		binding.searchSwipeRefresh.setOnRefreshListener { adapter.refresh() }
	}

	private fun initSearch() {
		binding.searchEdit.setOnEditorActionListener { _, id, _ ->
			if (id == EditorInfo.IME_ACTION_SEARCH) {
				updateTweetSearchFromInput()
				true
			} else {
				false
			}
		}

		binding.searchEdit.setOnKeyListener { _, keyCode, event ->
			if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
				updateTweetSearchFromInput()
				true
			} else {
				false
			}
		}
	}

	private fun updateTweetSearchFromInput() {
		binding.searchEdit.text?.trim().toString().let {
			if (it.isNotBlank() && viewModel.shouldDoSearch(it)) {
				viewModel.doSearch(it)
				binding.searchEdit.hideKeyboard()
			}
		}
	}

	override fun getViewBinding(
		inflater: LayoutInflater,
		container: ViewGroup?
	) = FragmentSearchBinding.inflate(inflater, container, false)

	private fun View.hideKeyboard() {
		val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		imm.hideSoftInputFromWindow(windowToken, 0)
	}

}
