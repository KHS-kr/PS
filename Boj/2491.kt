import java.util.*
import kotlin.math.max

fun main() = with(Scanner(System .`in`)) {
    val N = nextInt()
    val arr = Array(N) { nextInt() }

    var ret = 0
    var count = 0

    for(i in 0 until N - 1) {
        if(arr[i] <= arr[i + 1])
            count++
        else {
            ret = max(ret, count)
            count = 0
        }
    }
    ret = max(ret, count)
    count = 0

    for(i in 0 until N - 1) {
        if(arr[i] >= arr[i + 1])
            count++
        else {
            ret = max(ret, count)
            count = 0
        }
    }
    ret = max(ret, count)

    println(ret + 1)
}
