fun main() {
    val house = readLine()!!
    when {
        house == "gryffindor" -> println("bravery")
        house == "hufflepuff" -> println("loyalty")
        house == "slytherin" -> println("cunning")
        house == "ravenclaw" -> println("intellect")
        else -> println("not a valid house")
    }
}