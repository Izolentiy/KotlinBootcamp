package example.myapp.aquarium

import kotlin.math.PI

open class Aquarium(
    // Dimensions in cm
    open var width: Int = 20,
    open var height: Int = 40,
    open var length: Int = 100) {

    open val shape = "rectangle"
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }
    open var water: Double = 0.0
        get() = volume * 0.9

    companion object {
        // It looks like a static's analog
        var aquariumCount: Int = 0
    }

    init {
        ++aquariumCount
        println("Aquarium $aquariumCount\n" +
                "--------")
    }
    constructor(numberOfFish: Int) : this() {
        // 2 000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // Calculate height needed
        height = (tank / (length *  width)).toInt()
    }

    open fun printSize() {
        println("V: ${volume}cm^3, " +
                "W: ${width}cm, L: ${length}cm, H: ${height}cm\n")
    }
}

class CylinderAquarium (override var height: Int, var diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {

    override var volume: Int
        get() = (PI * diameter/2 * diameter/2 * height / 1000).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }
    override var water = volume * 0.8
    override val shape = "cylinder"
}