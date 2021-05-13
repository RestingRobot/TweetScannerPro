package com.restingrobot.tweetscannerpro.api

import com.restingrobot.tweetscannerpro.model.TweetSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *
 * Twitter API implementation
 *
 * Created by Jon Lange, 5/12/21
 */
interface TwitterAPI {

	/**
	 *
	 * Example request:
	 *
	 * https://api.twitter.com/2/tweets/search/recent?query=android&max_results=10&tweet.fields=author_id,id,text
	 *
	 * Example Response
	 *
		{
			"data": [
			{
				"author_id": "2882528051",
				"id": "1392617397060784130",
				"text": "#NowPlaying Stevie Wonder - Stevie Wonder - My Cherie Amour on #radiomotel #webradio #internetradio #tunein #alexa #android"
			},
			{
				"author_id": "2164191229",
				"id": "1392617388445638656",
				"text": "【Q】『異邦人』の著者は誰か？【A】アルベール・カミュ【I】フランスの小説家、劇作家 #一般常識 Android: https://t.co/oKtYFuirAJ iOS: https://t.co/OQyYo8uDhC"
			},
			{
				"author_id": "1103253527181361153",
				"id": "1392617382321995776",
				"text": "@BobbiBicker @Twitter @TwitterSpaces Android"
			},
			{
				"author_id": "1081877340341370880",
				"id": "1392617376949194761",
				"text": "@bb_apes This is your fault for being friends with someone who has an Android"
			},
			{
				"author_id": "2549735088",
				"id": "1392617375976116235",
				"text": "RT @CryptoHodlerId: Let's trade $CEL by @CelsiusNetwork at @OKEx and take some profit!🔥\n\nSign up and buy crypto to get $10 in free #BTC by…"
			},
			{
				"author_id": "986089337669365761",
				"id": "1392617375497789443",
				"text": "世界はAndroid基準なのに…"
			},
			{
				"author_id": "201044484",
				"id": "1392617375120470026",
				"text": "RT @TwitterLatAm: ¡Decilo! Ahora 🇦🇷 podrá enviar MDs de voz. Estamos ampliando nuestra prueba de mensajes de 140 segundos a la mayoría de l…"
			},
			{
				"author_id": "1144604858185596928",
				"id": "1392617374352826371",
				"text": "RT @ulascobain: Android kullananlara oç muamelesi yapılmasından bıktım\nTwitter'da sesli tweet atamıyoruz\nİnstada postun arkasına arka plan…"
			},
			{
				"author_id": "1613154805",
				"id": "1392617359446364164",
				"text": "RT @saamxthiana: uma hora ela aparece no Android outra hora pelo web quem entende \n\n#Bia #SérieAdolescente \n#CNCO #GrupoMusical\n#GabriellaD…"
			},
			{
				"author_id": "88112043",
				"id": "1392617349228814341",
				"text": "Androidなんですけど、なぜかGoogleのカレンダーの「予定」は通知が着て、「リマインダ」は全くこないという症状に悩まされてます。がちでせいかつにししょうがでてます。。ぐぐった対処法ではどうにもなりませんたすけて。。。"
			}
			],
			"meta": {
			"newest_id": "1392617397060784130",
			"oldest_id": "1392617349228814341",
			"result_count": 10,
			"next_token": "b26v89c19zqg8o3foswrepjgwlyku996y3nlqfj849ail"
		}
	*/
	@GET("tweets/search/recent")
	suspend fun getTweets(
		@Query("query") query: String,
		@Query("max_results") max: Int? = 10,
		@Query("tweet.fields") fields: String? = "author_id,id,text",
		@Query("next_token") after: String? = null
	) : TweetSearchResponse

	companion object {
		public const val BASE_URL = "https://api.twitter.com/2/"
	}

}
