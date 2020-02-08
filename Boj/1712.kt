import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var A = sc.nextInt()
    var B = sc.nextInt()
    var C = sc.nextInt()

    var count = 0

    if((C - B) <= 0)
        println(-1)
    else {
        println(A / (C - B) + 1)
    }
}
