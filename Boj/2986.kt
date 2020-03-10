import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    var k = 1

    var i = 2
    while(i * i <= N) {
        if(N mod i == 0) {
            k = N / i
            break
        }
        i++
    }
    println(N - k)
}

infix fun Int.mod(other : Int) = this % other
