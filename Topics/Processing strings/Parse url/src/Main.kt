fun main() {
    val url = readLine()!!
    val queryString = url.split("?", limit = 2)[1]
    val pairs = queryString.split("&").map {
        val pairList = it.split("=", limit = 2)
        Pair(pairList[0], pairList[1])
    }
    for (pair in pairs) {
        val (key, value) = pair
        val valueStr = value.ifEmpty { "not found" }
        println("$key : $valueStr")
    }
    val maybePassword = pairs.find { pair -> pair.first == "pass" }
    if (maybePassword != null) {
        println("password : ${maybePassword.second}")
    }
}