import java.util.*

var N = 0; var M = 0; var K = 0
var i = 0; var j = 0; var x = 0; var y = 0
lateinit var arr : Array<IntArray>
lateinit var dp : Array<IntArray>

fun main() = with(Scanner(System.`in`)) {
    N = nextInt(); M = nextInt()
    arr = Array(N + 1) { IntArray(M + 1) }
    dp = Array(N + 1) { IntArray(M + 1) { 0 } }
    for(i in 1..N)
        for(j in 1..M) {
            arr[i][j] = nextInt()
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1]
        }
    K = nextInt()

    for(k in 1..K) {
        i = nextInt(); j = nextInt(); x = nextInt(); y = nextInt()
        println(dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1])
    }
}
