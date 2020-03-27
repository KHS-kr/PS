import java.util.*
import kotlin.math.max

var N = 0
val arr = IntArray(50001)
var available = 0
val dp = Array(4) { IntArray(50001) }
val sum = IntArray(50001)

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    repeat(N) {
        arr[it + 1] = nextInt()
        sum[it + 1] = sum[it] + arr[it + 1]
    }
    available = nextInt()

    for(i in 1..3) {
        for(j in i * available..N) {
            //j번째 열차 안 끌 경우(이전값 그대로)와 j번째 열차 끌경
            dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - available] + (sum[j] - sum[j - available]))
        }
    }

    println(dp[3][N])
}
