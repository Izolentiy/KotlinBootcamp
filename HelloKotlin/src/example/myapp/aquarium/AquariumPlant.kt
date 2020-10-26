package example.myapp.aquarium

fun main() {
//    typeOnCompileTime()

//    propertyExtension()

//    nullableReceiver()
}


open class AquariumPlant(
    val color:String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

// Extension functions
fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

// Extension property
val AquariumPlant.isGreen: Boolean
    get() = color == "green"

// Know about nullable receivers
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun typeOnCompileTime() {
    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println('\n')
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // this method will print AquariumPlant
}

fun propertyExtension() {
    val plant = GreenLeafyPlant(20)
    println(plant.isGreen)
}

fun nullableReceiver() {
    val plant: AquariumPlant? = null
    plant.pull()
    // This method has no output
}


fun AquariumPlant.isRed() = color == "red" // can be extended
// fun AquariumPlant.isBig() = size > 50 // size cannot be accessed
// because it is private

