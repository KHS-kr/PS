import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()

    for(i : Int in (1..A).reversed())
        println(i)
}
