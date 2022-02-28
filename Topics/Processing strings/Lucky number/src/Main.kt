fun main() {
    val str = readLine()!!
    val half1 = str.substring(0, str.length / 2)
    val half2 = str.substring(str.length / 2)
    var sum1 = 0
    var sum2 = 0
    for (c in half1) {
        sum1 += c.toString().toInt()
    }
    for (c in half2) {
        sum2 += c.toString().toInt()
    }
    if (sum1 == sum2) {
        println("YES")
    } else println("NO")
}