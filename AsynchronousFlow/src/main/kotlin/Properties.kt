import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

@OptIn(InternalCoroutinesApi::class)
fun main(args: Array<String>) {
    runBlocking {
        println("Receiving numbers")
        withTimeoutOrNull(1000L) {
            sendNewNumbers().collect { println("$it") }
        }
    }
}

fun sendNewNumbers() = flow {
    listOf(1, 2, 3, 4, 5).forEach {
        delay(400L)
        emit(it)
    }
}