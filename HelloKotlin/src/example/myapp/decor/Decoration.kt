package example.myapp.decor

data class Decoration(val rocks: String) {
}

fun makeDecoration() {
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

fun main() {
    makeDecoration()
}