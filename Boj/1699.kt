import java.util.*
import kotlin.math.min

val dp = IntArray(100_001) { it }

fun main() = with(Scanner(System .`in`)) {
    val N = nextInt()

    for(i in 2..N) {
        var j = 2
        while(j * j <= i) {
            dp[i] = min(dp[i], dp[i - j * j] + 1)
            j++
        }
    }

    println(dp[N])
}
