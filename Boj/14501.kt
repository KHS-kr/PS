import java.util.*
import kotlin.math.max

var N = 0
val t = IntArray(16)
val p = IntArray(16)
val dp = IntArray(16)

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    repeat(N) {
        t[it + 1] = nextInt()
        p[it + 1] = nextInt()
        dp[it + 1] = p[it + 1]
    }

    for(i in 2..N) {
        for(j in 1 until i) {
            if(i - j >= t[j])
                dp[i] = max(p[i] + dp[j], dp[i])
        }
    }

    var ret = 0
    for(i in 1..N) {
        if(i + t[i] <= N + 1)
            if(ret < dp[i])
                ret = dp[i]
    }
    
    println(ret)
}
