import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()

    print(A.allsum())
}

fun Int.allsum() : Int {
    var s = 0
    for(i in 1..this)
        s += i
    return s
}
