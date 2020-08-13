import kotlinx.coroutines.*

var functionCalls = 0;

suspend fun completeMessage() {
    delay(500L)
    println("World!")
    functionCalls++
}

suspend fun improveMessage() {
    delay(1000L)
    println("Suspend function are cool")
    functionCalls++
}

fun main() {
    GlobalScope.launch {
        completeMessage()
    }
    GlobalScope.launch {
        improveMessage()
    }
    print("Hello, ")
    Thread.sleep(2000L)
    println("There have been $functionCalls calls so far")
}