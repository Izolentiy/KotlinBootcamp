package example.myapp

fun buildAquarium() {
    // Default
    val firstAquarium = Aquarium()
    firstAquarium.printSize()

    // Custom width
    val secondAquarium = Aquarium(width = 27)
    secondAquarium.printSize()

    // Custom height
    val thirdAquarium = Aquarium(height = 50)
    thirdAquarium.printSize()

    // Custom everything
    val fourthAquarium = Aquarium(25, 35, 110)
    fourthAquarium.printSize()

    // Secondary constructor
    val fifthAquarium = Aquarium(9)
    fifthAquarium.volume = 7000  // Setter
    fifthAquarium.printSize()

    // Cylinder aquarium
    val cylinderAquarium = CylinderAquarium(42, 25)
    cylinderAquarium.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}

fun main() {
//    buildAquarium()

    makeFish()
}