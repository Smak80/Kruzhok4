fun toPair(time: String): Pair<Int, Int> = time
    .split(":", ".")
    .map { it.toInt() }
    .let{ it[0] to it[1] }

fun Int.toTimeString() = "${this / 60}:${this % 60}"

fun getNearestFlyAfter(departures: List<String>, requestedTime: String) = toPair(requestedTime).run {
    val limit = first * 60 + second
    departures.map{
        toPair(it).let{ it.first * 60 + it.second }
    }.run {
        (filter { it > limit }.minOrNull() ?: min()).toTimeString()
    }
}

val Pair<Int, Int>.inMinutes get() = first * 60 + second

fun getFlightTime(departed: String, arrived: String): Int{
    val t1 = toPair(departed).inMinutes
    val t2 = toPair(arrived).inMinutes
    return (t2 - t1 + 1440) % 1440
}

fun getFlightLength(flight1: Pair<String, String>, flight2: Pair<String, String>): Int{
    val t1 = getFlightTime(flight1.first, flight1.second)
    val t2 = getFlightTime(flight2.first, flight2.second)
    return (t1 + t2) / 2
}

fun main() {
    val departures = listOf("8:01", "12.45", "17:30", "22:15")
    val myTime = "22.30"
    println(getNearestFlyAfter(departures, myTime))

    println(getFlightLength("12:00" to "14:00", "23:30" to "3:30").toTimeString())
}