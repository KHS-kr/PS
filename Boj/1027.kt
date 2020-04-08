import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
lateinit var arr : IntArray
lateinit var see : IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine().toInt()
    val temp = readLine().split(" ")
    arr = IntArray(N) { i -> temp[i].toInt() }
    see = IntArray(N)

    for(i in 0 until N) {
        var prev = Int.MIN_VALUE.toDouble()
        for(j in i + 1 until N) {
            val dt = (arr[j] - arr[i]) / (j - i).toDouble()
            if(dt > prev) {
                prev = dt
                see[i] += 1
                see[j] += 1
            }
        }
    }

    println(see.max())
}
