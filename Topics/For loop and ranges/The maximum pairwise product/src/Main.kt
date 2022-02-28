fun main() {
    val n = readLine()!!.toInt()
    var maxValue1 = 0
    var maxValue2 = 0

    repeat(n) {
        val number = readLine()!!.toInt()

        if (number > maxValue1) maxValue1 = number
        else if (number > maxValue2) maxValue2 = number
    }

    val product =
        // if second number has not been read, then the product is just the first number
        if (maxValue2 == 0) maxValue1
        // otherwise, it is a multiplication of both numbers
        else maxValue1 * maxValue2
    println(product)
}