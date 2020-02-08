import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()

    for(i : Int in 1..9)
        println("$A * $i = ${A * i}")
}
