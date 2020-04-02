import java.util.*
import kotlin.math.max

var N = 0; var M = 0
lateinit var arr : Array<IntArray>
lateinit var dp : Array<IntArray>

fun main() = with(Scanner(System.`in`)) {
    N = nextInt(); M = nextInt()
    arr = Array(N + 1) { IntArray(M + 1) }
    dp = Array(N + 1) { IntArray(M + 1) { -1 } }
    for(i in 0..N) dp[i][0] = 0
    for(j in 0..M) dp[0][j] = 0
    for(i in 1..N) for(j in 1..M) arr[i][j] = nextInt()

    for(i in 1..N) {
        for(j in 1..M) {
            dp[i][j] = max(dp[i - 1][j], max(dp[i][j - 1], dp[i - 1][j - 1])) + arr[i][j]
        }
    }
    println(dp[N][M])
}
