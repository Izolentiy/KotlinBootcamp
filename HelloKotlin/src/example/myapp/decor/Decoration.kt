package example.myapp.decor

// Data classes
data class Decoration(var rocks: String) {
}

data class Decoration2
    (var rocks: String, var wood: String, var diver: String) {
}

fun makeDecoration() {
    val decoration = Decoration2("rock", "wood", "diver")
    val (rock, wood, diver) = decoration  // Multiple assigning

    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration1.equals(decoration2))
    println(decoration2.equals(decoration3))

    println(decoration2 == decoration3)  // Structural equality
    println(decoration2 === decoration3)  // Referral equality

}

// Enum
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

fun makeChoice() {
    val color = Color.BLUE
    println(color.rgb.toString())
}

// Sealed class
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

fun main() {
//    makeDecoration()

    makeChoice()
}