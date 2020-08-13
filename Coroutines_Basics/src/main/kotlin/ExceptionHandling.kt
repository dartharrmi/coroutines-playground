import kotlinx.coroutines.*
import java.lang.IllegalStateException

fun main() {
    runBlocking {
        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job")
            throw IllegalStateException("Exception found")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw IllegalStateException("Async exception found")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("Exception handled: ${e.localizedMessage}")
        }
    }
}