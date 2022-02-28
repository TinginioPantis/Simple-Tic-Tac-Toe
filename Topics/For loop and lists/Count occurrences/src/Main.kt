fun main() {
    val sizeOfList = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (sizeOfList in 0 until sizeOfList) {
        mutList.add(readLine()!!.toInt())
    }
    val numberM = readLine()!!.toInt()
    println(mutList.count { it == numberM })
// val n = readLine()!!.toInt()
//    val items = MutableList<Int>(n) { readLine()!!.toInt() }
//    val m = readLine()!!.toInt()
//    var sum = 0
//    for (x in items) {
//        if (x == m) {
//            sum++
//        }
//    }
//    println(sum)
}