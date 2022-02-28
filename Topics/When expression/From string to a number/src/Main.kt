fun main() {
    val word = readLine()!!
    val result = when (word) {
        "One", "one" -> "1"
        "two", "Two" -> "2"
        "three", "Three" -> "3"
        "four", "Four" -> "4"
        "five", "Five" -> "5"
        "six", "Six" -> "6"
        "seven", "Seven" -> "7"
        "eight", "Eight" -> "8"
        "nine", "Nine" -> "9"
        else -> "Too much work..."
    }
    println(result)
}