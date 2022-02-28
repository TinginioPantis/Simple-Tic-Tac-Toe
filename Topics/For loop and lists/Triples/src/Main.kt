fun main() {
    val n = readLine()!!.toInt()
    val list = List(n) { readLine()!!.toInt() }
    val triples = list.windowed(3)
    fun isTriple(a: Int, b: Int, c: Int): Boolean = b == a + 1 && c == a + 2
    val count = triples.count { isTriple(it[0], it[1], it[2]) }
    println(count)
}