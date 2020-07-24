import react.dom.*
import kotlin.browser.document

val unwatchedVideos = listOf(
    Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
    Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
    Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
)

val watchedVideos = listOf(
    Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)

fun main() {
    render(document.getElementById("root")) {
//        h1 is really a function that takes a lambda parameter.
//        When we write +, we are really invoking the function unaryPlus (through operator overloading)
//        which takes care of appending the string to the enclosed HTML element.

//        Simply put, you can think of the + as "append my string inside this element."
        h1 {
            +"Hello, React+Kotlin/JS!"
        }
        div {
            h3 {
                +"Videos to watch"
            }

            unwatchedVideos.forEach { video ->
                p {
                    +"${video.speaker}: ${video.title}"

                }
            }

            h3 {
                +"Videos watched"
            }
            p {
                +"Tom Jerry: Mouseless development"
            }

        }
        div {
            h3 {
                +"John Doe: Building and breaking things"
            }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
    }
}
