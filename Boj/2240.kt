import java.util.*
import kotlin.math.max

fun main() {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt()
    val W = sc.nextInt()
    val jadu = Array(T) { sc.nextInt() }
    val dp = Array(2) { Array(T + 1) { Array(W + 2) { 0 } } }

    for(i in 1 until T + 1) {
        for(j in 1..W + 1) {
            if(jadu[i - 1] == 1) {
                dp[0][i][j] = max(dp[0][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1)
                dp[1][i][j] = max(dp[0][i - 1][j - 1], dp[1][i - 1][j])
            }
            else {
                if(i == 1 && j == 1)
                    continue
                dp[0][i][j] = max(dp[0][i - 1][j], dp[0][i - 1][j - 1])
                dp[1][i][j] = max(dp[0][i - 1][j - 1] + 1, dp[1][i - 1][j] + 1)
            }
        }
    }
    var retval = 0
    for(i in 1..W + 1) {
        retval = max(retval, max(dp[0][T][i], dp[1][T][i]))
    }

    println(retval)
}
