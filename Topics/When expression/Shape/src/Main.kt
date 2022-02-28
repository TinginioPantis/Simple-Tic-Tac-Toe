fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    when {
        n == 1 -> println("You have chosen a square")
        n == 2 -> println("You have chosen a circle")
        n == 3 -> println("You have chosen a triangle")
        n == 4 -> println("You have chosen a rhombus")
        else -> println("There is no such shape!")
    }
}