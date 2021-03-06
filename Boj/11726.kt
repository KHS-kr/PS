import java.util.*
val dp = IntArray(1001)

fun main() = with(Scanner(System .`in`)) {
    val N = nextInt()

    dp[0] = 1; dp[1] = 1
    for(i in 2..N)
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007

    println(dp[N])
}
