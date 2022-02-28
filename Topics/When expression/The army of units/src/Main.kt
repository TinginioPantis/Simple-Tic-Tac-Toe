fun main() {
    val n = readLine()!!.toInt()
    when {
        n < 1 -> println("no army")
        n in 1..4 -> println("few")
        n in 5..9 -> println("several")
        n in 10..19 -> println("pack")
        n in 20..49 -> println("lots")
        n in 50..99 -> println("horde")
        n in 100..249 -> println("throng")
        n in 250..499 -> println("swarm")
        n in 500..999 -> println("zounds")
        n >= 1000 -> println("legion")
    }
}