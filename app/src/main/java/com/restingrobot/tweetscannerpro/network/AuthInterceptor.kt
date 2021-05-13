package com.restingrobot.tweetscannerpro.network

import okhttp3.Interceptor
import okhttp3.Response


/**
 *
 * Interceptor class that automatically appends auth token to requests
 *
 * Created by Jon Lange, 5/12/21
 */
class AuthInterceptor: Interceptor {


	override fun intercept(chain: Interceptor.Chain): Response {
		var request = chain.request()

		val basicAuthToken = ""

		// Add basic auth header
		request = request.newBuilder()
			.header("Authorization", basicAuthToken)
			.build()

		return chain.proceed(request)
	}
}
