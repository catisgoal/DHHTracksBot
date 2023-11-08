package dhhbot.catisgoal.bot.twitter

import com.twitter.clientlib.TwitterCredentialsOAuth2
import com.twitter.clientlib.api.TwitterApi
import com.twitter.clientlib.auth.TwitterOAuth20Api
import com.twitter.clientlib.model.TweetCreateRequest
import dhhbot.catisgoal.bot.remote.db.dto.TweetDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import twitter4j.Twitter
import twitter4j.Twitter.TwitterBuilder
import twitter4j.v1.TwitterV1

fun Routing.postNewTweet() {/*authenticate(AUTH_TYPE.BEARER.name) {*/
    get("/bot/newTweet") {
       val twitterBuilder = Twitter.newBuilder().oAuthAccessToken("","")
           .oAuthConsumer("","")
           .build()
        val tweetTitle1 = randomTrackBasedTitle(
            dbTweetDTO = TweetDTO(
                trackName = "trackName", trackURL = "trackURL", artists = "artists", albumName = "albumName"
            )
        )
        val tweetTitle2 = randomAlbumBasedTitle(
            dbTweetDTO = TweetDTO(
                trackName = "trackName", trackURL = "trackURL", artists = "artists", albumName = "albumName"
            )
        )
        twitterBuilder.v1().tweets().updateStatus(tweetTitle1)
        twitterBuilder.v1().tweets().updateStatus(tweetTitle2)
    }/*}*/
}

private fun randomAlbumBasedTitle(dbTweetDTO: TweetDTO): String {
    return listOf(
        "Check out this song: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Discover '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Listen to '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Dive into this song: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Listen now: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Explore this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Discover new music: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Discover this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Listen to this song: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Check out this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Listen to this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}",
        "Check out this music: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists} from the album '${dbTweetDTO.albumName}': ${dbTweetDTO.trackURL}"
    ).random()
}

private fun randomTrackBasedTitle(dbTweetDTO: TweetDTO): String {
    return listOf(
        "Check out this song: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Discover '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Listen to '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Dive into this song: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Listen now: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Explore this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Discover this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Listen to this song: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Check out this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Listen to this track: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}",
        "Check out this music: '${dbTweetDTO.trackName}' by ${dbTweetDTO.artists}: ${dbTweetDTO.trackURL}"
    ).random()
}