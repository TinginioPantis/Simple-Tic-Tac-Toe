fun main() {
    val input = readLine()!!

    println(calc(input))
}

fun calc(input: String): String {
    var charCount = 0
    var lastChar: Char? = null
    var result = ""

    fun addToResult() {
        if (lastChar != null) {
            result += "$lastChar$charCount"
        }
    }

    for (char in input) {
        if (char == lastChar) {
            charCount++
        } else {
            addToResult()
            charCount = 1
        }
        lastChar = char
    }
    addToResult()

    return result
}