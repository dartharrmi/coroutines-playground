import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch(CoroutineName("MyCoroutine :)")) {
            println("This running from ${this.coroutineContext[CoroutineName.Key]}")
        }
    }
}