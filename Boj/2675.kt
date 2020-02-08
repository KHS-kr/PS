import java.util.*

fun main(args : Array<String>) {
    var scanner = Scanner(System.`in`)
    var N = scanner.nextLine().toInt()

    for(q in 1..N) {
        var n = scanner.nextInt()
        var str = scanner.next()
        for(c in str)
            for(i in 1..n)
                print(c)
        println()
    }
}
