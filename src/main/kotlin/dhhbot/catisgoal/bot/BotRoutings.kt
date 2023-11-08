package dhhbot.catisgoal.bot

import dhhbot.catisgoal.bot.twitter.postNewTweet
import io.ktor.server.routing.*

fun Routing.botRoutings(){
    postNewTweet()
}