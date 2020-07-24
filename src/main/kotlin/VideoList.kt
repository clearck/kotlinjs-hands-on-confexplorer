import kotlinx.css.Cursor
import kotlinx.css.cursor
import kotlinx.html.js.onClickFunction
import react.*
import styled.css
import styled.styledP

external interface VideoListProps : RProps {
    var videos: List<VideoModel>
    var selectedVideo: VideoModel?
    var onSelectVideo: (VideoModel) -> Unit
}

class VideoList : RComponent<VideoListProps, RState>() {

    override fun RBuilder.render() {
        props.videos.forEach { video ->
            styledP {
                css {
                    cursor = Cursor.pointer
                }
                key = video.id.toString()

                attrs {
                    onClickFunction = { props.onSelectVideo(video) }
                }

                if (video == props.selectedVideo) {
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
