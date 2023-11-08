package dhhbot.catisgoal.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.find


enum class AUTH_TYPE {
    BEARER
}

fun Application.configureSecurity() {
   /* install(Authentication) {
        bearer(AUTH_TYPE.BEARER.name) {
            authenticate { keyFromHeader ->
                val kMongo = KMongo.createClient(System.getenv("MONGODB_URL"))
                val collectionData =
                    kMongo.getDatabase(System.getenv("DB_NAME")).getCollection(System.getenv("BOT_AUTH"))
                val expectedKey = collectionData.find("""{_id:"botKey"}""").toList()[0].getString("botKey")
                when (keyFromHeader.token) {
                    expectedKey -> {
                        UserIdPrincipal("")
                    }

                    else -> {
                        null
                    }
                }
            }
        }
    }*/
}
