import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        mapOperator()
        filter()
        transform()
        take()
    }
}

/**
 * Just like [Collection.map]
 */
suspend fun mapOperator() {
    println("Mapping")
    (1..10)
        .asFlow()
        .map {
            delay(500L)
            "Mapping $it"
        }
        .collect {
            println(it)
        }
    println("Mapping finished")
}

/**
 * Just like [Collection.filter]
 */
suspend fun filter() {
    println("Filtering")
    (1..10)
        .asFlow()
        .filter {
            it % 2 == 0
        }
        .collect {
            println(it)
        }
    println("Filtering finished")
}

/**
 * General transformation operator, csn emit values at any point.
 */
@ExperimentalCoroutinesApi
suspend fun transform() {
    println("Filtering")
    (1..10)
        .asFlow()
        .transform { value ->
            emit("Emitting value: $value")
            emit(value)
        }
        .collect {
            println(it)
        }
    println("Filtering finished")
}

/**
 * Takes only the specified number of elements and discards the rest
 */
@ExperimentalCoroutinesApi
suspend fun take() {
    println("Filtering")
    (1..10)
        .asFlow()
        .take(3)
        .collect {
            println(it)
        }
    println("Filtering finished")
}

/**
 * Takes only the specified number of elements and discards the rest
 */
@ExperimentalCoroutinesApi
suspend fun reduce() {
    println("Filtering")
    (1..10)
        .asFlow()
        .reduce { accumulator, value -> accumulator * value }
    println("Filtering finished")
}