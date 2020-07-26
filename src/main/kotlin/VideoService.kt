import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.browser.window

object VideoService {
    suspend fun fetchVideo(id: Int): VideoModel =
        window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
            .await()
            .json()
            .await()
            .unsafeCast<VideoModel>()

    suspend fun fetchVideos(): List<VideoModel> = coroutineScope {
        (1..25).map { id ->
            async {
                fetchVideo(id)
            }
        }.awaitAll()
    }
}
