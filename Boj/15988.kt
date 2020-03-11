import java.util.*
val dp = Array(1_000_000 + 1) { 0L }

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for(i in 0 until N) {
        val input = sc.nextInt()
        println(onetwothree(input))
    }
}

fun onetwothree(n : Int) : Long {
    if(n <= 0) return 0
    if(dp[n] != 0L)
        return dp[n]
    for(i in 4..n) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009
    }

    return dp[n]
}
