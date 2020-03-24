import java.util.*

var str = ""

fun main() = with(Scanner(System .`in`)) {
    str = nextLine()

    for(i in str.indices) {
        if(palindrome(i)) {
            println(str.length + i)
            return@with
        }
    }
}

fun palindrome(n : Int) : Boolean {
    for(i in str.indices) {
        if(n + i >= str.length)
            break
        if(str[n + i] != str[str.length - i - 1])
            return false
    }
    return true
}
