fun main() {
    val n = readLine()!!.toInt()
    var sum = 0
    repeat(n) {
        val number = readLine()!!.toInt()
        sum += number
    }
    println(sum)
}