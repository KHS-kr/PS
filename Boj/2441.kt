import java.util.*

fun main(args : Array<String>) {
    var scanner : Scanner = Scanner(System.`in`)
    var A = scanner.nextInt()

    for(i in (1..A).reversed()) {
        for(j in 1..(A - i))
            print(" ")
        for(j in 1..i)
            print("*")
        println()
    }
}
