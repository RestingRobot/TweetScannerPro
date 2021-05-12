package com.restingrobot.tweetscannerpro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 *
 * Base Application Class for initialization and DI
 *
 * Created by Jon Lange, 5/11/21
 */

@HiltAndroidApp
class TweetScannerPro : Application() {

	// Init app defaults here
	override fun onCreate() {
		super.onCreate()


	}

}
