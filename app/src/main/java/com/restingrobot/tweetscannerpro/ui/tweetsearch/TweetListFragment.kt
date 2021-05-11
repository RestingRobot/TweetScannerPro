package com.restingrobot.tweetscannerpro.ui.tweetsearch

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restingrobot.tweetscannerpro.R

class TweetListFragment : Fragment() {

    companion object {
        fun newInstance() = TweetListFragment()
    }

    private lateinit var viewModel: TweetListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tweet_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TweetListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
