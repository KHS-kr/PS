import java.util.*
import kotlin.math.max

lateinit var x : Array<Int>
 var C = 0

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    C = sc.nextInt()
    x = Array(N) { sc.nextInt() }
    x.sort()

    var low = 1; var high = x[N - 1] - x[0]
    var result = 0

    while(low <= high) {
        val mid = (low + high) / 2

        if(check(mid)) {
            result = max(result, mid)
            low = mid + 1
        }
        else
            high = mid - 1
    }

    println(result)
}

fun check(mid : Int) : Boolean {
    var n = 1
    var temp = x[0]

    for(i in 1 until x.size) {
        if(x[i] - temp >= mid) {
            n++
            temp = x[i]
        }
    }

    return n >= C
}
