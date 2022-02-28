fun main() {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    var product = 1L
    for (i in a until b) {
        product *= i
    }
    println(product)
}