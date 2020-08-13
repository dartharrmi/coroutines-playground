import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val job1 = launch {
            // delay(3000L)
            println("Job1 launched")
            val job2 = launch {
                println("Job2 launched")
                delay(3000L)
                println("Job2 is finishing")
            }
            job2.invokeOnCompletion { println("Job2 is completed") }

            val job3 = launch {
                println("Job3 launched")
                delay(3000L)
                println("Job3 is finishing")
            }
            job3.invokeOnCompletion { println("Job2 is completed") }
        }

        // A hook used to process some when the job is completed (cancelled or completed by itself)
        job1.invokeOnCompletion { println("Job1 is completed") }

        delay(500L)
        println("Job1 will be cancelled")
        job1.cancel()
    }
}