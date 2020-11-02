package example.myapp.generics

open class WaterSupply(var needsProcessing: Boolean = false) {
    open val name: String = ""
}

class TapWater: WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true){
    fun filter() {
        needsProcessing = false
    }
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) cleaner.clean(waterSupply)
        println("water added")
//        check(!waterSupply.needsProcessing) {"water supply needs processing first"}
//        println("adding water from ${waterSupply}")
    }

    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

fun genericExample() {
//    val aquarium = Aquarium(TapWater())
//    println("water needs processing: " +
//            "${aquarium.waterSupply.needsProcessing}")

//    aquarium.waterSupply.addChemicalCleaners()
//    println("water needs processing: " +
//            "${aquarium.waterSupply.needsProcessing}")

//    val aquarium = Aquarium(TapWater())
//    addItemTo(aquarium)

    // Arguments
//    val aquarium2 = Aquarium("string")
//    println(aquarium2.waterSupply)

//    val aquarium3 = Aquarium(null)
//    if (aquarium3.waterSupply == null)
//        println("waterSupply is null")

//    val aquarium4 = Aquarium(LakeWater())
//    aquarium4.waterSupply.filter()
//    aquarium4.addWater()

//    val cleaner = TapWaterCleaner()
//    val aquarium = Aquarium(TapWater())
//    aquarium.addWater(cleaner)

    // Generic function
//    val aquarium = Aquarium(TapWater())
//    isWaterClean(aquarium)

    // Reified type
//    val aquarium = Aquarium(TapWater())
//    println(aquarium.hasWaterSupplyOfType<TapWater>())  // true

    // Extension function with generic type
    val aquarium = Aquarium(TapWater())
    println(aquarium.waterSupply.isOfType<TapWater>()) // true
}

fun genericArgument() {
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessing}")
}

// Extension generic function
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R


fun main() {
    genericExample()

//    genericArgument()
}