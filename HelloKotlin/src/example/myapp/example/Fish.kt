package example.myapp.example

data class Fish (var name: String)

fun fishExamples() {
    val fish = Fish("splashy")  // lowercase
    myWith (fish.name) {
        println(capitalize())
    }

    // with myWith() inline, this becomes
//    fish.name.capitalize()
}

fun myWith(name: String, block: String.() -> Unit){
    name.block()
}
//inline fun myWith(name: String, block: String.() -> Unit){
//    name.block()
//}

//------

fun runExample() {
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)
//    JavaRun.runNow({
//        println("Passing a lambda as a Runnable")
//    })
    /*You can instantiate, override and make a call to a SAM with one line of code,
     using the pattern: Class.singleAbstractMethod { lambda_of_override }*/
}

//-------------main
fun main () {
    fishExamples()
}