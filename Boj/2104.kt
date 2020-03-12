import java.util.*
import kotlin.math.max
import kotlin.math.min

val arr = Array(1000001) { 0 }

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    for(i in 1..N)
        arr[i] = sc.nextInt()


    println(dac(1, N))
}

fun dac(s: Int, e: Int): Long {
    if (s == e) return arr[s] * arr[s].toLong()
    val mid = s + e shr 1
    var ans = max(dac(s, mid), dac(mid + 1, e))
    var min: Long = arr[mid].toLong()
    var l: Int
    var r: Int
    var sum: Long = arr[mid].toLong()
    r = mid
    l = r
    while (r - l < e - s) {
        val p: Long = if (l > s) (arr[l - 1] + sum) * min(min, arr[l - 1].toLong()) else -1L
        val q: Long = if (r < e) (arr[r + 1] + sum) * min(min, arr[r + 1].toLong()) else -1L
        if (p > q) {
            sum += arr[l - 1]
            min = min(min, arr[l - 1].toLong())
            l--
        } else {
            sum += arr[r + 1]
            min = min(min, arr[r + 1].toLong())
            r++
        }
        ans = max(ans, sum * min)
    }
    return ans
}
