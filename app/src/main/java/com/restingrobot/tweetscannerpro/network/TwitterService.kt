package com.restingrobot.tweetscannerpro.network

import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import com.restingrobot.tweetscannerpro.api.TwitterAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * Service Implementation of Twitter API
 *
 * Created by Jon Lange, 5/12/21
 */
class TwitterService(baseUrl: String, authInterceptor: Interceptor? = null) {

	protected val retrofit: Retrofit

	init {
		retrofit = provideRetrofit(baseUrl, provideOkHttpClient(authInterceptor))
	}

	private fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.client(client)
			.baseUrl(baseUrl)
			.addConverterFactory(buildGsonConverter())
			.build()
	}

	private fun provideOkHttpClient(authInterceptor: Interceptor? = null): OkHttpClient {
		val okHttpClientBuilder = OkHttpClient.Builder()
			.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
			.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
			.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)

		// Add Auth Interceptor if we have one
		authInterceptor?.let { okHttpClientBuilder.addInterceptor(it) }

		// Create HTTP Logger, but redact auth header
		val logger = HttpLoggingInterceptor().also {
			it.level = HttpLoggingInterceptor.Level.BASIC
			it.redactHeader("Authorization")
		}

		// Add HTTP logger, (can be removed for non-debug later)
		okHttpClientBuilder.addInterceptor(logger)

		return okHttpClientBuilder.build()
	}

	// TODO: Not sure if I need this with basic models
	private fun buildGsonConverter(): GsonConverterFactory {
		val gson = GsonBuilder().create()
		return GsonConverterFactory.create(gson)
	}

	companion object {
		const val DEFAULT_TIMEOUT = 30L
	}
}
