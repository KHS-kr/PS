import java.util.*
import kotlin.math.abs

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arr = IntArray(N) { nextInt() }
    val ret = IntArray(N) { i -> president(arr, arr[i]) }
    var minret = 0
    for(i in ret.indices)
        if(ret[minret] > ret[i])
            minret = i
    var minarr = Int.MAX_VALUE
    for(i in arr.indices) {
        if(ret[i] == ret[minret] && minarr > arr[i])
            minarr = arr[i]
    }

    println(minarr)
}

fun president(arr : IntArray, n : Int) : Int {
    var ret = 0
    for(i in arr)
        ret += abs(n - i)
    return ret
}
