import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val str = sc.nextLine()

    println(dial(str))
}

fun dial(str : String) : Int {
    var ret = 0

    for(c in str) {
        when(c) {
            in 'A'..'C' -> ret += 3
            in 'D'..'F' -> ret += 4
            in 'G'..'I' -> ret += 5
            in 'J'..'L' -> ret += 6
            in 'M'..'O' -> ret += 7
            in 'P'..'S' -> ret += 8
            in 'T'..'V' -> ret += 9
            in 'W'..'Z' -> ret += 10
        }
    }
    return ret
}
