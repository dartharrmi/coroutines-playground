import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

@OptIn(InternalCoroutinesApi::class)
fun main(args: Array<String>) {
    runBlocking {
        println("Receiving prime numbers")
        sendPrimes().collect {
            println("Received: $it")
        }
        println("Finished prime numbers")

        println("Receiving numbers")
        sendNumbersAsFlow().collect {
            println("Received: $it")
        }
        println("Finished numbers")
    }
}

fun sendPrimes(): Flow<Int> = flow {
    val primesList = listOf(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    primesList.forEach {
        delay(it * 100L)
        emit(it)
    }
}

fun sendNumbersAsFlow() = listOf(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29).asFlow()