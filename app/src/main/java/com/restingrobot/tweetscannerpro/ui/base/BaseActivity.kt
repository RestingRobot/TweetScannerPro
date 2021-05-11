package com.restingrobot.tweetscannerpro.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.restingrobot.tweetscannerpro.R
import com.restingrobot.tweetscannerpro.databinding.ActivityBaseBinding
import com.restingrobot.tweetscannerpro.ui.viewmodel.TweetViewModel

class BaseActivity : AppCompatActivity() {

	private val viewModel: TweetViewModel by viewModels()

	private lateinit var navController: NavController

	// Setup activity with nav controller and toolbar
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = ActivityBaseBinding.inflate(layoutInflater)

		setContentView(binding.root)
		setSupportActionBar(binding.toolbar)

		val navHostFragment =
			supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

		navController = navHostFragment.navController
		NavigationUI.setupActionBarWithNavController(this, navController)
	}

	override fun onSupportNavigateUp(): Boolean {
		navController.navigateUp()
		return super.onSupportNavigateUp()
	}
}
