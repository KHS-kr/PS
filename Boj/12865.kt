import java.util.*
import kotlin.math.max

var N = 0; var K = 0
val v = IntArray(101) //무게
val w = IntArray(101) //가치
val dp = Array(101) { IntArray(100_001) }

fun main() = with(Scanner(System .`in`)) {
    N = nextInt()
    K = nextInt()

    repeat(N) {
        w[it + 1] = nextInt()
        v[it + 1] = nextInt()
    }

    for(i in 1..N) {
        for(j in 1..K) {
            dp[i][j] = dp[i - 1][j] //i번쨰 물건 안가져갔을경우
            if(j - w[i] >= 0) //i번째 물건 가져갔을 경우
                dp[i][j] = max(dp[i][j], dp[i - 1][j - w[i]] + v[i])
        }
    }

    println(dp[N - 1][K])
}
