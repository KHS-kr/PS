import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var n = scanner.nextInt(); scanner.nextLine()
    var A = scanner.nextLine()

    print(A.allsum(n))
}

fun String.allsum(n : Int) : Int {
    var s = 0
    for(i in 0..(n - 1)) {
        s += this.get(i).toInt() - 48
    }
    return s
}
