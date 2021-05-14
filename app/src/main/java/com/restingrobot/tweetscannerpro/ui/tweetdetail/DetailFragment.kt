package com.restingrobot.tweetscannerpro.ui.tweetdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.restingrobot.tweetscannerpro.databinding.FragmentDetailBinding
import com.restingrobot.tweetscannerpro.databinding.FragmentSearchBinding
import com.restingrobot.tweetscannerpro.ui.base.BaseFragment
import com.restingrobot.tweetscannerpro.ui.viewmodel.TweetViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 *
 * Fragment to display detailed Tweet information
 *
 * Created by Jon Lange, 5/11/21
 */
@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, TweetViewModel>() {

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
	) = FragmentDetailBinding.inflate(inflater, container, false)

}
