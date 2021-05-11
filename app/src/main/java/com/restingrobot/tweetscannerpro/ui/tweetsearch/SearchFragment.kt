package com.restingrobot.tweetscannerpro.ui.tweetsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.restingrobot.tweetscannerpro.databinding.FragmentSearchBinding
import com.restingrobot.tweetscannerpro.ui.base.BaseFragment
import com.restingrobot.tweetscannerpro.ui.viewmodel.TweetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, TweetViewModel>() {

	override val viewModel: TweetViewModel by activityViewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setHasOptionsMenu(false)
		setup()
	}


	private fun setup() = with(binding) {
		// TODO: Initialize tweet list view, search bar, and anything else
	}

	override fun getViewBinding(
		inflater: LayoutInflater,
		container: ViewGroup?
	) = FragmentSearchBinding.inflate(inflater, container, false)

}
