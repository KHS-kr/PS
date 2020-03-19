import java.util.*
var count = 0
lateinit var sb : StringBuilder

fun main() = with(Scanner(System .`in`)) {
    val N = nextInt()
    sb = StringBuilder()

    Hanoi(1, 3, 2, N)
    println(count)
    println(sb.toString())
}

fun Hanoi(from : Int, to : Int, other : Int, size : Int) {
    count++
    if(size == 1) {
        sb.append("$from $to\n")
        return
    }

    Hanoi(from, other, to, size - 1)
    sb.append("$from $to\n")
    Hanoi(other, to, from, size - 1)
}
