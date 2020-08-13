import kotlinx.coroutines.*

fun main() {
    runBlocking {
        // Unconfined switches thread when the coroutine is paused/resumed
        launch(Dispatchers.Unconfined) {
            println("Unconfined_1 dispatcher. Thread: ${Thread.currentThread().name}")
            delay(500L)
            println("Unconfined_2 dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("I/O dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyAwesomeThread")) {
            println("newSingleThreadContext execution. Thread: ${Thread.currentThread().name}")
        }
    }
}