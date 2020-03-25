import java.util.*
import kotlin.math.max

val dp = IntArray(1_000 + 1)
lateinit var arr : IntArray
var N = 0

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    arr = IntArray(N + 1) { i -> if(i != 0) nextInt() else 0 }

    for(i in 1..N) {
        for(j in 1..i) {
            dp[i] = max(dp[i], dp[i - j] + arr[j])
        }
    }
    println(dp[N])
}
