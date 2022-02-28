fun main() {
    val sequence = readLine()!!.lowercase()
    val gCCount = sequence.count { c -> c == 'c' || c == 'g' }
    val result = gCCount / sequence.length.toDouble() * 100
    println(result)
}