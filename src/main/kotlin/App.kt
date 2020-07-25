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
}

class App : RComponent<RProps, AppState>() {
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
                videos = unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video -> setState { currentVideo = video } }
            }

            h3 {
                +"Videos watched"
            }
            videoList {
                videos = watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video -> setState { currentVideo = video } }
            }

        }

        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
            }
        }
    }
}
