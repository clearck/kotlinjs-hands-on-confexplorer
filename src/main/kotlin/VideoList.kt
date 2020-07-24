import kotlinx.css.Cursor
import kotlinx.css.cursor
import kotlinx.html.js.onClickFunction
import react.*
import styled.css
import styled.styledP
import kotlin.browser.window

external interface VideoListProps : RProps {
    var videos: List<Video>
}

external interface VideoListState : RState {
    var selectedVideo: Video?
}

class VideoList : RComponent<VideoListProps, VideoListState>() {

    override fun RBuilder.render() {
        props.videos.forEach { video ->
            styledP {
                css {
                    cursor = Cursor.pointer
                }
                key = video.id.toString()
                attrs {
                    onClickFunction = {
//                      State should only ever be modified from within the setState
//                      lambda. This allows the React renderer to detect any changes
//                      to the state, and to re-render portions of our UI quickly and
//                      efficiently.
                        setState {
                            selectedVideo = video
                        }
                    }
                }
                if (video == state.selectedVideo) {
                    +"▶ "
                }
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}
