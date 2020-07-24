import react.dom.*
import kotlin.browser.document

val unwatchedVideos = listOf(
    VideoModel(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
    VideoModel(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
    VideoModel(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
)

val watchedVideos = listOf(
    VideoModel(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)

fun main() {
    render(document.getElementById("root")) {
        // Tell React to render the App component as a child of root
        child(App::class) {}
    }
}
