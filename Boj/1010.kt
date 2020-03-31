import java.util.*

var N = 0; var M = 0

fun main() = with(Scanner(System.`in`)) {
    val T = nextInt()
    repeat(T) {
        N = nextInt()
        M = nextInt()

        val dp = Array(N + 1) { LongArray(M + 1) }

        for (i in 0..M)
            dp[1][i] = i.toLong()
        for (i in 2..N) {
            for (j in i..M) {
                for (k in (i..j).reversed())
                    dp[i][j] += dp[i - 1][k - 1]
            }
        }
        println(dp[N][M])
    }
}
