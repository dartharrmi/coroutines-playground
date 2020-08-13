import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val firstDeferred = async { getFirstValue() }
        val secondDeferred = async { getSecondValue() }

        println("Processing...")
        delay(500L)
        println("Waiting for value")

        val firstNumber = firstDeferred.await()
        val seconfNumber = secondDeferred.await()

        println("Total is: ${firstNumber + seconfNumber}")
    }
}

suspend fun getFirstValue(): Int {
    delay(1000L)
    return Random.nextInt(100).also {
        println("Returning first value: $it")
    }
}

suspend fun getSecondValue(): Int {
    delay(2000L)
    return Random.nextInt(100).also {
        println("Returning second value: $it")
    }
}