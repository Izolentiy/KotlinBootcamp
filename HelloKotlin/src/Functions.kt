import kotlin.random.Random

fun main() {
//    isUnit()

//    feedTheFish()

//    swim()  // uses default speed
//    swim("slow")  // positional argument
//    swim(speed="turtle-like")  // named parameter

//    filtersSample()

//    lambdaTests()
}

// Unit object, I'm not sure what is it yet
fun isUnit() {
    val isUnit = println("This is an expression")
    println(isUnit) // this will print out "kotlin.Unit"
}

// Functions with parameters
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday", "Sunday");
    return week[Random.nextInt(week.size)]
}

fun fishFood (day: String): String {
    var food = ""
    // more flexible switch's analog
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "worms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

// Default parameters in functions
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22,
                      dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

// Single-expression functions
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

// Filters
fun filtersSample() {
    /* This function will prints the words that begins with 'P' letter */
    val decorations = listOf("rock", "pagoda",
        "plastic plant", "alligator", "flowerpot")

    // eager, create a new list
    val eager = decorations.filter {it[0] == 'p'}
    println("eager: $eager")

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter {it[0] == 'p'}
    println("filtered: $filtered")

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    // I don't understand why these .map{} and e.t.c is needed yet
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
}

// Lambdas and higher-order functions
fun lambdaTests() {
    var dirtyLevel = 20

    // This val contains lambda,
    // and can be called just like a function
    val waterFilter = {dirty: Int -> dirty / 2}
    val waterFilter2: (Int) -> Int = {dirty -> dirty / 2}

    // The argument I pass doesn't have to be a lambda
    // It may be a regular function
    println(updateDirty(30, waterFilter))

    // Passing the regular function as an argument
    println(updateDirty(15, ::increaseDirty))
}

fun increaseDirty(start: Int) = start + 1

fun waterFilter(dirty: Int): Int {
    /* Lambda's regular function analog */
    return dirty / 2
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    /* This functions as the second argument takes a function!
    * functions that takes Int and returns Int.*/
    return operation(dirty)
}