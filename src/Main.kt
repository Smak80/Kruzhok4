fun isPalindrome(string: String): Boolean {
    val lString = string.lowercase()
    var fString = ""
    for (ch in lString) {
        if (ch in 'а'..'я' || ch in 'a'..'z' || ch in '1'..'9' || ch == 'ё'){
            fString += ch
        }
    }
    val rString = fString.reversed()
    return (fString == rString)
}

fun isPalindrome2(string: String) = string.lowercase()
    .filter { it.isLetterOrDigit() }
    .let { it == it.reversed() }

fun main() {
    val str = "abba"
    val str2 = "Коту тащат уток"
    val str3 = "Муза, ранясь шилом опыта, ты помолишься на разум."
    println(isPalindrome(str))
    println(isPalindrome(str2))
    println(isPalindrome(str3))

    println(isPalindrome2(str))
    println(isPalindrome2(str2))
    println(isPalindrome2(str3))
}