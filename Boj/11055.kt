import java.util.*
import kotlin.math.max

var N = 0
val arr = IntArray(1000)
val dp = IntArray(1000)

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    repeat(N) {
        arr[it] = nextInt()
        dp[it] = arr[it]
    }
    var ret = 0

    for(i in 0 until N) {
        for(j in 0 until i)
            if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i])
                dp[i] = dp[j] + arr[i]
        ret = max(ret, dp[i])
    }

    println(ret)
}
