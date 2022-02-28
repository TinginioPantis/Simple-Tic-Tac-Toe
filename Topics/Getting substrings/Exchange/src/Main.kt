fun main() {
    val input = readLine()!!
    val newWord = input.last() + input.substring(1, input.lastIndex) + input.first()
    println(newWord)
}