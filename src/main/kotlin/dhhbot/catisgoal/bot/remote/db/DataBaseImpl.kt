package dhhbot.catisgoal.bot.remote.db

import org.litote.kmongo.KMongo

fun getATrackFromDB() {
    val kMongo = KMongo.createClient(System.getenv("MONGODB_URL"))
    val collectionData =
        kMongo.getDatabase(System.getenv("DB_NAME")).getCollection(System.getenv("TRACKS_COLLECTION_NAME"))
        // abhi kaam nahi karunga
}