package com.restingrobot.tweetscannerpro.di

import com.restingrobot.tweetscannerpro.api.TwitterAPI
import com.restingrobot.tweetscannerpro.network.AuthInterceptor
import com.restingrobot.tweetscannerpro.network.TwitterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 *
 * Module for network services
 *
 * Created by Jon Lange, 5/12/21
 */
@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

	@Singleton
	@Provides
	fun providesTwitterService() =
		TwitterService.getInstance(TwitterAPI.BASE_URL, AuthInterceptor())
}
