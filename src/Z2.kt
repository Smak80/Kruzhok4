fun toPair(time: String): Pair<Int, Int> = time
    .split(":", ".")
    .map { it.toInt() }
    .let{ it[0] to it[1] }

fun getNearestFlyAfter(departures: List<String>, requestedTime: String){
    toPair(requestedTime)
}

fun main() {
    val departures = listOf("8:31", "12.45", "17:30", "22:15")
    val myTime = "14.00"
    println(getNearestFlyAfter(departures, myTime))
}