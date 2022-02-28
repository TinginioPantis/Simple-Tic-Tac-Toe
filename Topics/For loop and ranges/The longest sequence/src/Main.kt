fun main() {
    val n = readLine()!!.toInt()

    val numbers = (1..n).map { readLine()!!.toInt() }
//    println(numbers)
    val windowed = numbers.windowed(2)
//    println(windowed)
    val scanned = windowed.scan(1) { numbersInSeq, window ->
        val previous = window[0]
        val current = window[1]

        if (current >= previous) numbersInSeq + 1 else 1
    }
//    println(scanned)
    println(scanned.maxOrNull())
}