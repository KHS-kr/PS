import java.util.*

val dp = Array(1001) { IntArray(1001) }
var N = 0; var K = 0
fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    K = nextInt()

    for(i in 1..N) {
        for(j in 0..N) {
            if(i == j || j == 0)
                dp[i][j] = 1
            else
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007
        }
    }

    println(dp[N][K])
}
