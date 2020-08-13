import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("First context is: $coroutineContext")

            withContext(Dispatchers.IO) {
                println("Second context is: $coroutineContext")
            }
            println("Third context is: $coroutineContext")
        }
    }
}