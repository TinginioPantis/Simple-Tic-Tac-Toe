fun main() {
    val input = readLine()!!
    val reversedInput = input.reversed()
    if (input == reversedInput) {
        println("yes")
    } else {
        println("no")
    }
}