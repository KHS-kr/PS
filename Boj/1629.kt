import java.util.*
import kotlin.math.pow

fun main() {
    val sc = Scanner(System.`in`)
    val A = sc.nextLong()
    val B = sc.nextLong()
    val C = sc.nextLong()


    println(multiply(A, B, C) % C)
}

fun multiply(A : Long, B : Long, C : Long) : Long {
    if(B == 1L)
        return A
    val temp = multiply(A, B / 2, C)

    return if(B % 2 == 1L) ((temp * temp ) % C * A) % C
    else (temp * temp) % C
}
