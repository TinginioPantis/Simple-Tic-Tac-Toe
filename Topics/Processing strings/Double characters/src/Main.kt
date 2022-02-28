fun main() {
    val input = readLine()!!
    val result = input.split("").joinToString("") { it + it }
    println(result)
}