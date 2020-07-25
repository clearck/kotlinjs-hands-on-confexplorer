import react.dom.*
import kotlin.browser.document

fun main() {
    render(document.getElementById("root")) {
        // Tell React to render the App component as a child of root
        child(App::class) {}
    }
}
