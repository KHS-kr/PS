import java.util.*

var N = 0
var dp = Array(31) { LongArray(31) }

fun main() = with(Scanner(System.`in`)) {
    repeat(1000) {
        N = nextInt()
        if(N == 0)
            return@with
        println(pill(N, 0))
    }
}

fun pill(n : Int, half : Int) : Long{
    if(dp[n][half] != 0L)
        return dp[n][half]
    if(n < 0 || half < 0)
        return 0
    else if(n + half == 0 || n == 0) {
        return 1
    }

    dp[n][half] += pill(n - 1, half + 1)
    if(half > 0)
        dp[n][half] += pill(n, half - 1)

    return dp[n][half]
}
