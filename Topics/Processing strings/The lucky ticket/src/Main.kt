fun main() {
    val input = readLine()!!.map { it.digitToInt() }.toList()
    if (input[0] + input[1] + input[2] == input[3] + input[4] + input[5]) {
        println("Lucky")
    } else println("Regular")
}