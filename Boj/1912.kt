import java.util.*
import kotlin.math.max

var N = 0
val arr = IntArray(100_001)
val dp = IntArray(100_001)

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    repeat(N) {
        arr[it] = nextInt()
    }

    dp[0] = arr[0]
    var ret = dp[0]

    for(i in 1 until N) {
        dp[i] = max(dp[i - 1] + arr[i], arr[i])
        ret = max(ret, dp[i])
    }

    println(ret)
}
