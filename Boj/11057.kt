import java.util.*

val dp = Array(1001) { IntArray(10)}
var N = 0
fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    for(i in 0 until 10)
        dp[1][i] = 1

    for(i in 2..N)
        for(j in 0 until 10)
            for(k in j until 10)
                dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007

    println((dp[N].sum()) % 10007)
}
