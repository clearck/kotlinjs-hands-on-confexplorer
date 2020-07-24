import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
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
                onSelectVideo = { video -> state.currentVideo = video }
            }

            h3 {
                +"Videos watched"
            }
            videoList {
                videos = watchedVideos
            }

        }
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
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
