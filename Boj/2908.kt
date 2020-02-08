import java.util.*
import kotlin.math.max

fun main(args : Array<String>) {
    val sc = Scanner(System.`in`)
    var A = sc.nextInt()
    var B = sc.nextInt()

    print(max(A.reversed(), B.reversed()))
}

fun Int.reversed() : Int{
    var t = this / 100
    return (this % 10) * 100 + (this % 100 / 10) * 10 + t
}
