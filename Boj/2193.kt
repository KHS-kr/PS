import java.util.*
val dp = LongArray(91)
var N = 0

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()

    dp[1] = 1
    dp[2] = 1
    for(i in 3..N) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[N])
}
