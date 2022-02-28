fun main() {
    val str = readLine()!!
    val subStr = readLine()!!

    var count = 0
    var foundAt = str.indexOf(subStr)
    while (foundAt != -1) {
        count += 1
        foundAt = str.indexOf(subStr, foundAt + 1)
    }
    println(count)
}