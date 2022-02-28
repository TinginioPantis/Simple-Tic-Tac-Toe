fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // Do not touch lines above
    val newNumber = numbers[0]
    numbers[0] = numbers[numbers.size - 1]
    numbers[numbers.size - 1] = newNumber
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}