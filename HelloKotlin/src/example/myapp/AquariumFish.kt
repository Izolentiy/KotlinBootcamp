package example.myapp

interface FishAction {
    fun eat()
    fun swim() {
        println("swim")  // Default implementation
    }
}

interface FishColor {
    val color: String
}

// Abstract class

/*
abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}

class Shark : AquariumFish() {
    override val color = "gray"

    override fun eat(){
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish() {
    override val color = "gold"

    override fun eat() {
        println("eat algae")
    }
}
*/

// Interface delegation

object GoldColor : FishColor {
    // This is how singleton looks like in Kotlin
    override val color = "gold"
}

class PrintingFishAction(var food: String) : FishAction {
    override fun eat() = println(food)
}

class Shark(fishColor: FishColor = GoldColor) :
    FishAction, FishColor by fishColor{
    override fun eat() = println("hunt and eat fish")
}

class Plecostomus : FishAction by PrintingFishAction("eat algae"),
    FishColor by GoldColor{
    override fun eat() = println("eat algae")
}