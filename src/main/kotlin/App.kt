import kotlinx.css.*
import react.*
import react.dom.div
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledDiv
import styled.styledH1

external interface AppState : RState {
    var currentVideo: VideoModel?
    var unwatchedVideos: List<VideoModel>
    var watchedVideos: List<VideoModel>
}

class App : RComponent<RProps, AppState>() {

    // Override init method from state to fill state with predefined values
    override fun AppState.init() {
        unwatchedVideos = listOf(
            VideoModel(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
            VideoModel(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
            VideoModel(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
        )

        watchedVideos = listOf(
            VideoModel(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
        )

    }

    override fun RBuilder.render() {
//      h1 is really a function that takes a lambda parameter.
//      When we write +, we are really invoking the function unaryPlus (through operator overloading)
//      which takes care of appending the string to the enclosed HTML element.

//      Simply put, you can think of the + as "append my string inside this element."
        styledH1 {
            css {
                fontFamily = "sans-serif"
            }
            +"Hello, React+Kotlin/JS!"
        }
        div {
            h3 {
                +"Videos to watch"
            }

            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video -> setState { currentVideo = video } }
            }

            h3 {
                +"Videos watched"
            }
            videoList {
                videos = state.watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video -> setState { currentVideo = video } }
            }

        }

        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
                unwatchedVideo = video in state.unwatchedVideos
                onWatchedButtonPressed = { video ->
                    throw NotImplementedError()
                }
            }
        }
    }
}
