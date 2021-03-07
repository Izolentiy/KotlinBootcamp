package example.myapp.example

import kotlin.reflect.full.*

@ImAPlant class Plant {

    @get:OnGet
    val isGrowing: Boolean = false

    @set:OnSet
    var needsFood: Boolean = false

    fun trim() {}
    fun fertilize() {}
}

//fun testAnnotations() {
//    val plantObject = Plant::class
//    for (a in plantObject.annotations) {
//        println(a.annotationClass.simpleName)
//    }
//}

fun testAnnotations() {
    val plantObject = Plant::class
    val myAnnotationObject = plantObject.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}

//------
annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

//-------------main
fun main () {
    testAnnotations()
}