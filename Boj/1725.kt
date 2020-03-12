import java.util.*
import kotlin.math.max
import kotlin.math.min

val arr = Array(1000001) { 0 }

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    for(i in 1..N)
        arr[i] = sc.nextInt()
    println(histogram(1, N))
}

fun histogram(start : Int, end : Int) : Int {
    if(start == end - 1) return arr[start]
    val mid = (start + end) / 2
    var result = max(histogram(start, mid), histogram(mid, end))

    var width = 1; var height = arr[mid]
    var l = mid; var r = mid

    while(start < l || r < end) {
        val left = if(l > start) min(height, arr[l - 1]) else -1
        val right = if(r < end) min(height, arr[r + 1]) else -1

        if(left > right) {
            height = left
            l--
        }
        else {
            height = right
            r++
        }
        width++
        result = max(result, width * height)
    }

    return result
}
