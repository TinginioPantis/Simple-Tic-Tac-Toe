fun main() {
    val input = readLine()!!
    if (input.isEmpty()) println("")
    else {
        val firstSymbol = input.first()
        val withFirstSymbolRemoved = input.drop(1)
        when (firstSymbol) {
            'i' -> println(withFirstSymbolRemoved.toInt() + 1)
            's' -> println(withFirstSymbolRemoved.reversed())
            else -> println(input)
        }
    }
}